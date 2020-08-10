package com.openfaas.function;

import com.openfaas.function.service.ContactsService;
import com.openfaas.function.service.ContactsServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

import java.util.UUID;

public class Handler implements com.openfaas.model.IHandler {
    private ContactsService contactsService = new ContactsServiceImpl();

    public IResponse Handle(IRequest req) {
        String contactsId = req.getPath().get("contactsId");
        mResponse mRes = contactsService.findContactsById(UUID.fromString(contactsId));

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
