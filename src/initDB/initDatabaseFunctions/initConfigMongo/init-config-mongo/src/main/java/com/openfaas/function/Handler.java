package com.openfaas.function;

import com.openfaas.function.repository.ConfigRepository;
import com.openfaas.function.repository.ConfigRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private ConfigRepository configRepository = new ConfigRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (configRepository.init()) {
            res.setBody("Success");
        }else
            res.setBody("Fail");

        return res;
    }
}
