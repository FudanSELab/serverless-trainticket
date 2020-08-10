package com.openfaas.function;

import com.openfaas.function.service.OrderService;
import com.openfaas.function.service.OrderServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

public class Handler implements com.openfaas.model.IHandler {
    private OrderService orderService = new OrderServiceImpl();

    public IResponse Handle(IRequest req) {
        String OrderId = req.getPath().get("orderId");
        String orderStatus = req.getPath().get("orderStatus");
        mResponse mRes = orderService.modifyOrder(OrderId, Integer.parseInt(orderStatus));

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
