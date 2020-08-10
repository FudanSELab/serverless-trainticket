package com.openfaas.function;

import com.openfaas.function.entity.*;
import com.openfaas.function.service.OrderService;
import com.openfaas.function.service.OrderServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * function10 getSoldTickets
 * <p>
 * get ticket list by date and trip id
 * Http Method : POST
 * <p>
 * 原API地址： "http://ts-order-service:12031/api/v1/orderservice/order/tickets"
 * <p>
 * 输入：(object)Seat
 * 输出：(Object)LeftTicketInfo
 */
public class Handler implements com.openfaas.model.IHandler {

    private OrderService orderService = new OrderServiceImpl();

    public IResponse Handle(IRequest req) {
        Seat seatRequest = JsonUtils.json2Object(req.getBody(), Seat.class);
        mResponse mRes = orderService.getSoldTickets(seatRequest);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
