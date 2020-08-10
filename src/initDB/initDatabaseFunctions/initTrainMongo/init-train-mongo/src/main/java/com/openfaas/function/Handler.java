package com.openfaas.function;

import com.openfaas.function.repository.TrainTypeRepository;
import com.openfaas.function.repository.TrainTypeRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private TrainTypeRepository trainTypeRepository = new TrainTypeRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (trainTypeRepository.init()) {
            res.setBody("Success");
        }

        return res;
    }
}
