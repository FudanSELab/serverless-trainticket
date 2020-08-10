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
        String accountId = req.getPath().get("accountId");
        mResponse mRes = contactsService.findContactsByAccountId(UUID.fromString(accountId));

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,content-type");
	    return res;
    }
}
