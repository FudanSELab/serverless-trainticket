package com.openfaas.function.service;


import com.openfaas.function.entity.TrainType;
import com.openfaas.function.repository.TrainTypeRepository;
import com.openfaas.function.repository.TrainTypeRepositoryImpl;


public class TrainServiceImpl implements TrainService {

    private TrainTypeRepository repository=new TrainTypeRepositoryImpl();

    @Override
    public TrainType retrieve(String id) {
        if (repository.findById(id) == null) {
            return null;
        } else {
            return repository.findById(id);
        }
    }

}
