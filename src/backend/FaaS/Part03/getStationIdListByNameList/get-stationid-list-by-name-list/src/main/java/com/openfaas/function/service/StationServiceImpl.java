package com.openfaas.function.service;

import com.openfaas.function.repository.StationRepository;
import com.openfaas.function.repository.StationRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.util.ArrayList;
import java.util.List;

public class StationServiceImpl implements StationService {

    private StationRepository repository=new StationRepositoryImpl();

    String success = "Success";

    @Override
    public mResponse queryByIdBatch(List<String> idList) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < idList.size(); i++) {
            Station station = repository.findById(idList.get(i));
            if (station != null) {
                result.add(station.getName());
            }
        }
        if (!result.isEmpty()) {
            return new mResponse<>(1, success, result);
        } else {
            return new mResponse<>(0, "No stationNamelist according to stationIdList", result);
        }

    }
}
