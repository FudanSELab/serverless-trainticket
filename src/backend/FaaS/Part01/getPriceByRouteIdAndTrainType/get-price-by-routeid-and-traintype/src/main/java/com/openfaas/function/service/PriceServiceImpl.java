package com.openfaas.function.service;

import com.openfaas.function.repository.PriceConfigRepositoryImpl;
import edu.fudan.common.util.mResponse;

import com.openfaas.function.entity.PriceConfig;
import com.openfaas.function.repository.PriceConfigRepository;


public class PriceServiceImpl implements PriceService {

    private PriceConfigRepository priceConfigRepository = new PriceConfigRepositoryImpl();


    String noThatConfig = "No that config";

    @Override
    public mResponse findByRouteIdAndTrainType(String routeId, String trainType) {
        PriceConfig priceConfig = priceConfigRepository.findByRouteIdAndTrainType(routeId, trainType);
        if (priceConfig == null) {
            return new mResponse<>(0, noThatConfig, routeId + trainType);
        } else {
            return new mResponse<>(1, "Success", priceConfig);
        }
    }

}
