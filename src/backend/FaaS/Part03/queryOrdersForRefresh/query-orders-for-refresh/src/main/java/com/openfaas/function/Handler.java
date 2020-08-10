package com.openfaas.function;

import com.openfaas.function.entity.OrderInfo;
import com.openfaas.function.service.OrderService;
import com.openfaas.function.service.OrderServiceImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


public class Handler implements com.openfaas.model.IHandler {

    private OrderService orderService = new OrderServiceImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,content-type");


        try {
            OrderInfo info = JsonUtils.json2Object(req.getBody(), OrderInfo.class);
            mResponse mRes = orderService.queryOrdersForRefresh(info,info.getLoginId());
            res.setBody(JsonUtils.object2Json(mRes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
