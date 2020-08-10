package com.openfaas.function;

import com.openfaas.function.repository.AddMoneyRepository;
import com.openfaas.function.repository.AddMoneyRepositoryImpl;
import com.openfaas.function.repository.PaymentRepository;
import com.openfaas.function.repository.PaymentRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private AddMoneyRepository addMoneyRepository = new AddMoneyRepositoryImpl();
    private PaymentRepository paymentRepository = new PaymentRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (addMoneyRepository.init() && paymentRepository.init()) {
            res.setBody("Success");
        } else res.setBody("Fail");


        return res;
    }
}
