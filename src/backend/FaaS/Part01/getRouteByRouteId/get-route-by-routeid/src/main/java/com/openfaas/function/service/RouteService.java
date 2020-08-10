package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;

public interface RouteService {

    /**
     * get route by id
     *
     * @param routeId route id
     * @return Response
     */
    mResponse getRouteById(String routeId);

}
