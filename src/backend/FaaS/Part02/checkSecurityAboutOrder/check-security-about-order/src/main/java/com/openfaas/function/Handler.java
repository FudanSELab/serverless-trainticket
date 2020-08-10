package com.openfaas.function;

import com.openfaas.function.service.OrderService;
import com.openfaas.function.service.OrderServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

import java.util.Date;

public class Handler implements com.openfaas.model.IHandler {

    private OrderService orderService=new OrderServiceImpl();
    public IResponse Handle(IRequest req) {
        String accountId = req.getPath().get("accountId");
        String checkDate = req.getPath().get("checkDate");
        mResponse mRes = orderService.checkSecurityAboutOrder(new Date(checkDate),accountId);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

	    return res;
    }
}
