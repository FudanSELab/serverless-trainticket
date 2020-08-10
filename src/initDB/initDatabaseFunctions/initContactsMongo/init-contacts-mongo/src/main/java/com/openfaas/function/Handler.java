package com.openfaas.function;

import com.openfaas.function.repository.ContactsRepository;
import com.openfaas.function.repository.ContactsRepositoryImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


public class Handler implements com.openfaas.model.IHandler {

    private ContactsRepository contactsRepository = new ContactsRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (contactsRepository.init()) {
            res.setBody("Success");
        } else res.setBody("Fail");


        return res;
    }
}
