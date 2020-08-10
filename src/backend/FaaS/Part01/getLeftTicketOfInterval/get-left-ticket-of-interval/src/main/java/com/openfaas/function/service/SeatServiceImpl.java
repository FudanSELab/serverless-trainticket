package com.openfaas.function.service;

import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

import java.util.List;
import java.util.Set;

/**
 * @author fdse
 */

public class SeatServiceImpl implements SeatService {

    private OkHttpClient client = new OkHttpClient();

    private String function09_URI = "gateway.openfaas:8080/function/get-route-by-tripid.openfaas-fn";
    private String function10_URI = "gateway.openfaas:8080/function/get-sold-tickets.openfaas-fn";
    private String function11_URI = "gateway.openfaas:8080/function/get-traintype-by-tripid.openfaas-fn";
    private String function12_URI = "gateway.openfaas:8080/function/query-config-entity-by-config-name.openfaas-fn";


    @Override
    public mResponse getLeftTicketOfInterval(Seat seatRequest) {
        int numOfLeftTicket = 0;
        mResponse<Route> routeResult;
        TrainType trainTypeResult;
        LeftTicketInfo leftTicketInfo;

        //Distinguish G\D from other trains
        String trainNumber = seatRequest.getTrainNumber();
        //SeatServiceImpl.LOGGER.info("Seat request To String: {}", seatRequest.toString());

        //SeatServiceImpl.LOGGER.info("[SeatService getLeftTicketOfInterval] TrainNumber start with G|D {}", trainNumber);

        //Call the micro service to query all the station information for the trains
        String ret = "";
        try {
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function09_URI + "/tripId/" + trainNumber)
                    .get()
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        routeResult = JsonUtils.json2Object(ret, mResponse.class);


        //Call the micro service to query for residual Ticket information: the set of the Ticket sold for the specified seat type
        String json = JsonUtils.object2Json(seatRequest);
        try {
            RequestBody body = RequestBody.create(
                    MediaType.parse("application/json"), json);

            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function10_URI)
                    .post(body)
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
        leftTicketInfo = JsonUtils.conveterObject(mRes.getData(), LeftTicketInfo.class);


        //Calls the microservice to query the total number of seats specified for that vehicle
        try {
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function11_URI + "/tripId/" + seatRequest.getTrainNumber())
                    .get()
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mRes = JsonUtils.json2Object(ret, mResponse.class);
        trainTypeResult = JsonUtils.conveterObject(mRes.getData(), TrainType.class);


        //Counting the seats remaining in certain sections
        List<String> stationList = JsonUtils.conveterObject(routeResult.getData(), Route.class).getStations();
        int seatTotalNum;
        if (seatRequest.getSeatType() == SeatClass.FIRSTCLASS.getCode()) {
            seatTotalNum = trainTypeResult.getConfortClass();
            //SeatServiceImpl.LOGGER.info("[SeatService getLeftTicketOfInterval] The request seat type is confortClass and the total num is {}", seatTotalNum);
        } else {
            seatTotalNum = trainTypeResult.getEconomyClass();
            //SeatServiceImpl.LOGGER.info("[SeatService getLeftTicketOfInterval] The request seat type is economyClass and the total num is {}", seatTotalNum);
        }

        int solidTicketSize = 0;
        if (leftTicketInfo != null) {
            String startStation = seatRequest.getStartStation();
            Set<Ticket> soldTickets = leftTicketInfo.getSoldTickets();
            solidTicketSize = soldTickets.size();
            //To find out if tickets already sold are available
            for (Ticket soldTicket : soldTickets) {
                String soldTicketDestStation = soldTicket.getDestStation();
                //Tickets can be allocated if the sold ticket's end station before the start station of the request
                if (stationList.indexOf(soldTicketDestStation) < stationList.indexOf(startStation)) {
                    //SeatServiceImpl.LOGGER.info("[SeatService getLeftTicketOfInterval] The previous distributed seat number is usable! {}", soldTicket.getSeatNo());
                    numOfLeftTicket++;
                }
            }
        }
        //Count the unsold tickets

        double direstPart = getDirectProportion();
        Route route = JsonUtils.conveterObject(routeResult.getData(), Route.class);
        if (route.getStations().get(0).equals(seatRequest.getStartStation()) &&
                route.getStations().get(route.getStations().size() - 1).equals(seatRequest.getDestStation())) {
            //do nothing
        } else {
            direstPart = 1.0 - direstPart;
        }

        int unusedNum = (int) (seatTotalNum * direstPart) - solidTicketSize;
        numOfLeftTicket += unusedNum;

        return new mResponse<>(1, "Get Left Ticket of Internal Success", numOfLeftTicket);
    }


    private double getDirectProportion() {
        String configName = "DirectTicketAllocationProportion";
        String ret = "";
        try {
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function12_URI + "/configName/" + configName)
                    .get()
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse<Config> configValue = JsonUtils.json2Object(ret, mResponse.class);
        //  return Double.parseDouble(configValue.getData().getValue());
        return Double.parseDouble(JsonUtils.conveterObject(configValue.getData(), Config.class)
                .getValue());
    }
}