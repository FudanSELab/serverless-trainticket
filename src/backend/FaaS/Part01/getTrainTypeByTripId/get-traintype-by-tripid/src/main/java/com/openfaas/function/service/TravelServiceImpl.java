package com.openfaas.function.service;

import com.openfaas.function.repository.TripRepositoryImpl;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.TripRepository;
import okhttp3.OkHttpClient;

import java.util.*;

/**
 * @author fdse
 */
public class TravelServiceImpl implements TravelService {

    private TripRepository repository = new TripRepositoryImpl();

    private OkHttpClient client = new OkHttpClient();

    private String function04_URI = "gateway.openfaas:8080/function/get-traintype-by-traintypeid.openfaas-fn";

    String success = "Success";
    String noContent = "No Content";

    @Override
    public mResponse getTrainTypeByTripId(String tripId) {
        TripId tripId1 = new TripId(tripId);
        TrainType trainType = null;
        Trip trip = repository.findByTripId(tripId1);
        if (trip != null) {
            trainType = getTrainType(trip.getTrainTypeId());
        }
        if (trainType != null) {
            return new mResponse<>(1, success, trainType);
        } else {
            return new mResponse<>(0, noContent, null);
        }
    }

    private TrainType getTrainType(String trainTypeId) {
        String ret = "";
        try {
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function04_URI + "/trainTypeId/" + trainTypeId)
                    .get()
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse TrainTypeRes = JsonUtils.json2Object(ret, mResponse.class);

        TrainType trainType = null;
        if (TrainTypeRes.getStatus() == 1) {
            trainType = JsonUtils.conveterObject(TrainTypeRes.getData(), TrainType.class);

        }
        return trainType;
    }


}
