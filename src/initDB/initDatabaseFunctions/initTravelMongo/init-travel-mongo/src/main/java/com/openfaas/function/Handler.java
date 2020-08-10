package com.openfaas.function;

import com.openfaas.function.repository.TripRepository;
import com.openfaas.function.repository.TripRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private TripRepository tripRepository = new TripRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (tripRepository.init()) {
            res.setBody("Success");
        }

        return res;
    }
}
