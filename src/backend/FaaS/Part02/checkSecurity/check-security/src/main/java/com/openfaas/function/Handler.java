package com.openfaas.function;

import com.openfaas.function.service.SecurityService;
import com.openfaas.function.service.SecurityServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

public class Handler implements com.openfaas.model.IHandler {
private SecurityService securityService=new SecurityServiceImpl();
    public IResponse Handle(IRequest req) {
        String accountId = req.getPath().get("accountId");
        mResponse mRes = securityService.check(accountId);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

	    return res;
    }
}
