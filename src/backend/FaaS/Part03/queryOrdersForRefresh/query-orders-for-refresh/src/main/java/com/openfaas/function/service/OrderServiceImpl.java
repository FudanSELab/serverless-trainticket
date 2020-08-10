package com.openfaas.function.service;

import com.openfaas.function.repository.OrderRepositoryImpl;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.OrderRepository;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

import java.util.*;

/**
 * @author fdse
 */

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();
    private OkHttpClient client = new OkHttpClient();

    String function44_URI = "gateway.openfaas:8080/function/get-stationid-list-by-name-list.openfaas-fn";


    String success = "Success";
    String orderNotFound = "Order Not Found";

    @Override
    public mResponse<ArrayList<Order>> queryOrders(OrderInfo qi, String accountId) {
        //1.Get all orders of the user
        ArrayList<Order> list = orderRepository.findByAccountId(UUID.fromString(accountId));
        //2.Check is these orders fit the requirement/
        if (qi.isEnableStateQuery() || qi.isEnableBoughtDateQuery() || qi.isEnableTravelDateQuery()) {
            ArrayList<Order> finalList = new ArrayList<>();
            for (Order tempOrder : list) {
                boolean statePassFlag = false;
                boolean boughtDatePassFlag = false;
                boolean travelDatePassFlag = false;
                //3.Check order state requirement.
                if (qi.isEnableStateQuery()) {
                    if (tempOrder.getStatus() != qi.getState()) {
                        statePassFlag = false;
                    } else {
                        statePassFlag = true;
                    }
                } else {
                    statePassFlag = true;
                }
                //4.Check order travel date requirement.
                if (qi.isEnableTravelDateQuery()) {
                    if (tempOrder.getTravelDate().before(qi.getTravelDateEnd()) &&
                            tempOrder.getTravelDate().after(qi.getBoughtDateStart())) {
                        travelDatePassFlag = true;
                    } else {
                        travelDatePassFlag = false;
                    }
                } else {
                    travelDatePassFlag = true;
                }
                //5.Check order bought date requirement.
                if (qi.isEnableBoughtDateQuery()) {
                    if (tempOrder.getBoughtDate().before(qi.getBoughtDateEnd()) &&
                            tempOrder.getBoughtDate().after(qi.getBoughtDateStart())) {
                        boughtDatePassFlag = true;
                    } else {
                        boughtDatePassFlag = false;
                    }
                } else {
                    boughtDatePassFlag = true;
                }
                //6.check if all requirement fits.
                if (statePassFlag && boughtDatePassFlag && travelDatePassFlag) {
                    finalList.add(tempOrder);
                }
            }
            return new mResponse<>(1, "Get order num", finalList);
        } else {
            return new mResponse<>(1, "Get order num", list);
        }
    }

    @Override
    public mResponse queryOrdersForRefresh(OrderInfo qi, String accountId) {
        mResponse mRes=queryOrders(qi, accountId);
        ArrayList<Order> orders = JsonUtils.conveterObject(mRes.getData(), ArrayList.class);
        ArrayList<String> stationIds = new ArrayList<>();
        ArrayList<Order> result = new ArrayList<>();

//        for (Order order : orders) {
//            stationIds.add(order.getFrom());
//            stationIds.add(order.getTo());
//        }
        for (int i=0;i<orders.size();i++) {
            Order order=JsonUtils.conveterObject(orders.get(i),Order.class);
            result.add(order);
            stationIds.add(order.getFrom());
            stationIds.add(order.getTo());
        }

        List<String> names = queryForStationId(stationIds);
        for (int i = 0; i < result.size(); i++) {
            result.get(i).setFrom(names.get(i * 2));
            result.get(i).setTo(names.get(i * 2 + 1));
        }
        return new mResponse<>(1, "Query Orders For Refresh Success", result);
    }


    public List<String> queryForStationId(List<String> ids) {

//        HttpEntity requestEntity = new HttpEntity(ids, headers);
//        ResponseEntity<Response<List<String>>> re = restTemplate.exchange(
//                "http://ts-station-service:12345/api/v1/stationservice/stations/namelist",
//                HttpMethod.POST,
//                requestEntity,
//                new ParameterizedTypeReference<Response<List<String>>>() {
//                });
//        OrderServiceImpl.LOGGER.info("Name List is: {}", re.getBody().toString());
//        return re.getBody().getData();

        String ret = "";
        String json = JsonUtils.object2Json(ids);
        try {
            RequestBody body = RequestBody.create(
                    MediaType.parse("application/json"), json);

            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function44_URI)
                    .post(body)
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
        List<String> resList = JsonUtils.conveterObject(mRes.getData(), List.class);
        return resList;
    }

}

