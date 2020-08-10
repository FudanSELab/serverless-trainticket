package com.openfaas.function.repository;


import com.openfaas.function.entity.Route;

import java.util.ArrayList;

/**
 * @author fdse
 */
public interface RouteRepository {

    /**
     * find route by id
     *
     * @param id id
     * @return Route
     */
    Route findById(String id);

}
