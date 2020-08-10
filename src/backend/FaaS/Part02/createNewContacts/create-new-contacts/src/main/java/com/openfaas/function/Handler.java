package com.openfaas.function;

import com.openfaas.function.entity.Contacts;
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
        Response res = new Response();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,content-type");

        try {
            Contacts aci = JsonUtils.json2Object(req.getBody(), Contacts.class);
            mResponse mRes = contactsService.create(aci);
            res.setBody(JsonUtils.object2Json(mRes));
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return res;
    }
}
