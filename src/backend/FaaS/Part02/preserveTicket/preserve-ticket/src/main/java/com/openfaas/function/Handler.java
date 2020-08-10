package com.openfaas.function;

import com.openfaas.function.entity.OrderTicketsInfo;
import com.openfaas.function.service.PreserveService;
import com.openfaas.function.service.PreserveServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

public class Handler implements com.openfaas.model.IHandler {

    private PreserveService preserveService = new PreserveServiceImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,content-type");

        try {
            OrderTicketsInfo info = JsonUtils.json2Object(req.getBody(), OrderTicketsInfo.class);
            mResponse mRes = preserveService.preserve(info);
            res.setBody(JsonUtils.object2Json(mRes));
        } catch (Exception e) {
        }
        return res;
    }
}
