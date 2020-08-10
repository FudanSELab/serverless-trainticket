package com.openfaas.function;

import com.openfaas.function.repository.UserRepository;
import com.openfaas.function.repository.UserRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private UserRepository userRepository = new UserRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (userRepository.init()) {
            res.setBody("Success");
        } else res.setBody("Fail");


        return res;
    }
}
