package com.openfaas.function;

import com.openfaas.function.repository.PriceConfigRepository;
import com.openfaas.function.repository.PriceConfigRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private PriceConfigRepository priceConfigRepository = new PriceConfigRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (priceConfigRepository.init()) {
            res.setBody("Success");
        }

        return res;
    }
}
