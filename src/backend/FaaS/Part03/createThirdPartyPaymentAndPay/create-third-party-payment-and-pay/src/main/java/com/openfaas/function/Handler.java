package com.openfaas.function;

import com.openfaas.function.entity.Payment;
import com.openfaas.function.entity.PaymentInfo;
import com.openfaas.function.service.PaymentService;
import com.openfaas.function.service.PaymentServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

public class Handler implements com.openfaas.model.IHandler {

    private PaymentService paymentService = new PaymentServiceImpl();

    public IResponse Handle(IRequest req) {
        PaymentInfo info= JsonUtils.json2Object(req.getBody(),PaymentInfo.class);
        Payment payment=new Payment();
        payment.setOrderId(info.getOrderId());
        payment.setUserId(info.getUserId());
        payment.setPrice(info.getPrice());
        mResponse mRes = paymentService.pay(payment);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
