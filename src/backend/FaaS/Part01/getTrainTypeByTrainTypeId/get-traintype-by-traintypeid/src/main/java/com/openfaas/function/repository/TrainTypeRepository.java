package com.openfaas.function.repository;

import com.openfaas.function.entity.TrainType;



public interface TrainTypeRepository {

    TrainType findById(String id);

}
