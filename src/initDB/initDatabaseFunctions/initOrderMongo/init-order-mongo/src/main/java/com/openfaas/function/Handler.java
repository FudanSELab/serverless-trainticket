package com.openfaas.function;

import com.openfaas.function.repository.OrderRepository;
import com.openfaas.function.repository.OrderRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (orderRepository.init()) {
            res.setBody("Success");
        }else res.setBody("Fail");

        return res;
    }
}
