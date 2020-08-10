package com.openfaas.function;

import com.openfaas.function.repository.SecurityRepository;
import com.openfaas.function.repository.SecurityRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private SecurityRepository securityRepository = new SecurityRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (securityRepository.init()) {
            res.setBody("Success");
        }else
            res.setBody("Fail");

        return res;
    }
}
