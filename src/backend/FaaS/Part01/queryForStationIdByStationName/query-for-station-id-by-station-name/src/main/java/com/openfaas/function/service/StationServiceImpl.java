package com.openfaas.function.service;

import com.openfaas.function.repository.StationRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.StationRepository;


public class StationServiceImpl implements StationService {

    private StationRepository repository=new StationRepositoryImpl();

    String success = "Success";

    @Override
    public mResponse queryForId(String stationName) {
        Station station = repository.findByName(stationName);
        if (station  != null) {
            return new mResponse<>(1, success, station.getId());
        } else {
            return new mResponse<>(0, "Not exists", stationName);
        }
    }

}
