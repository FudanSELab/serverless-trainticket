package com.openfaas.function;

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
        String userId = req.getPath().get("userId");
        String money = req.getPath().get("money");
        mResponse mRes = insidePaymentService.drawBack(userId,money);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

	    return res;
    }
}
