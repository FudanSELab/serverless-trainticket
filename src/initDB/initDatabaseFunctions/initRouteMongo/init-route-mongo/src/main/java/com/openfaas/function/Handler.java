package com.openfaas.function;

import com.openfaas.function.repository.RouteRepository;
import com.openfaas.function.repository.RouteRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private RouteRepository routeRepository = new RouteRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (routeRepository.init()) {
            res.setBody("Success");
        } else res.setBody("Fail");


        return res;
    }
}
