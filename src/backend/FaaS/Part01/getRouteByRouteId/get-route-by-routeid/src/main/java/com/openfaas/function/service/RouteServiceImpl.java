package com.openfaas.function.service;

import com.openfaas.function.repository.RouteRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.RouteRepository;


public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository = new RouteRepositoryImpl();

    String success = "Success";

    @Override
    public mResponse getRouteById(String routeId) {
        Route route = routeRepository.findById(routeId);
        if (route == null) {
            return new mResponse<>(0, "No content with the routeId", routeId);
        } else {
            return new mResponse<>(1, success, route);
        }

    }

}