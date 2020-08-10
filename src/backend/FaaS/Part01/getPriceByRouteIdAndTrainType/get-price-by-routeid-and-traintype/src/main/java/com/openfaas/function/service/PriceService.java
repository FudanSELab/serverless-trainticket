package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;

import com.openfaas.function.entity.PriceConfig;


/**
 * @author fdse
 */
public interface PriceService {

    mResponse findByRouteIdAndTrainType(String routeId, String trainType);

}
