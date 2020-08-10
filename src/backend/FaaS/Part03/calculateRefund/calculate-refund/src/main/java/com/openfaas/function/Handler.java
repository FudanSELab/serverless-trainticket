package com.openfaas.function;

import com.openfaas.function.service.CancelService;
import com.openfaas.function.service.CancelServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

public class Handler implements com.openfaas.model.IHandler {
    private CancelService cancelService = new CancelServiceImpl();

    public IResponse Handle(IRequest req) {

        Response res = new Response();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,content-type");

        try {
           String orderId = req.getPath().get("orderId");
           mResponse mRes = cancelService.calculateRefund(orderId);
           res.setBody(JsonUtils.object2Json(mRes));
        } catch (Exception e) {
            e.printStackTrace();
        }

	    return res;
    }
}
