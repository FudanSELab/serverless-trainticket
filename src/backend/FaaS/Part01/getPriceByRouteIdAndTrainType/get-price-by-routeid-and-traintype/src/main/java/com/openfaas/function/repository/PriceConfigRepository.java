package com.openfaas.function.repository;


import com.openfaas.function.entity.PriceConfig;
import java.util.List;
import java.util.UUID;


public interface PriceConfigRepository  {

    PriceConfig findByRouteIdAndTrainType(String routeId,String trainType);


}
