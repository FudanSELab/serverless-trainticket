package com.openfaas.function.service;

import com.openfaas.function.entity.TrainType;


public interface TrainService {

    TrainType retrieve(String id);

}
