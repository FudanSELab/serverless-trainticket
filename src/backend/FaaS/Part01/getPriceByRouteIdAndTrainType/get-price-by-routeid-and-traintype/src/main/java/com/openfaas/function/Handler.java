package com.openfaas.function;

import com.openfaas.function.service.PriceService;
import com.openfaas.function.service.PriceServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * function5 findByRouteIdAndTrainType
 * FINSHED/UNTESTED
 * get price by routeid and train type
 * Http Method : GET
 * <p>
 * 原API地址："http://ts-price-service:16579/api/v1/priceservice/prices/" + routeId + "/" + trainType
 * <p>
 * 输入：(String)routeId , (String)trainType
 * 输出：(Object)priceConfig
 */
public class Handler implements com.openfaas.model.IHandler {

    private PriceService priceService = new PriceServiceImpl();

    public IResponse Handle(IRequest req) {

        String routeId = req.getPath().get("routeId");
        String trainType = req.getPath().get("trainType");

        mResponse mRes = priceService.findByRouteIdAndTrainType(routeId,trainType);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
