package com.openfaas.function;

import com.openfaas.function.entity.PaymentInfo;
import com.openfaas.function.service.InsidePaymentService;
import com.openfaas.function.service.InsidePaymentServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

public class Handler implements com.openfaas.model.IHandler {
    private InsidePaymentService insidePaymentService = new InsidePaymentServiceImpl();

    public IResponse Handle(IRequest req) {
    	   Response res = new Response();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,content-type");

        try {
        PaymentInfo info= JsonUtils.json2Object(req.getBody(),PaymentInfo.class);
        mResponse mRes = insidePaymentService.pay(info);
        res.setBody(JsonUtils.object2Json(mRes));
        System.out.println(res.getBody());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
        

    }
    
}
