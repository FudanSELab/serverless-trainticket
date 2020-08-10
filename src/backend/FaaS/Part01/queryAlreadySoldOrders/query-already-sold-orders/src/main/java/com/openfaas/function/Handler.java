package com.openfaas.function;

import com.openfaas.function.service.OrderService;
import com.openfaas.function.service.OrderServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.DateUtils;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

import java.util.Date;


/**
 * function6 queryAlreadySoldOrders
 * query sold tickets
 * Http Method : GET
 * <p>
 * 原API地址：/api/v1/orderservice/order/{travelDate}/{trainNumber}
 * <p>
 * 输入：(String)travelDate,(String)trainNumber
 * 输出：(Object)SoldTicket
 */

public class Handler implements com.openfaas.model.IHandler {

    private OrderService orderService = new OrderServiceImpl();

    public IResponse Handle(IRequest req) {

        String travelDateStr = req.getPath().get("travelDate");
        Date travelDate = new Date(travelDateStr);

        String trainNumber = req.getPath().get("trainNumber");

        mResponse mRes = orderService.queryAlreadySoldOrders(travelDate, trainNumber);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
