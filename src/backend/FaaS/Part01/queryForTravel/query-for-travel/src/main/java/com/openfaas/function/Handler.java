package com.openfaas.function;

import com.openfaas.function.service.BasicService;
import com.openfaas.function.service.BasicServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;

import com.openfaas.function.entity.*;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

/**
 * function2 queryForTravel
 * FINISHED/UNTESTED
 * <p>
 * query basic travel information
 * Http Method : POST
 * <p>
 * 原API地址："http://ts-basic-service:15680/api/v1/basicservice/basic/travel"
 * <p>
 * 输入：(object)Travel
 * 输出：(object)TravelResult
 */

public class Handler implements com.openfaas.model.IHandler {

    private BasicService basicService = new BasicServiceImpl();

    public IResponse Handle(IRequest req) {
        Travel info = JsonUtils.json2Object(req.getBody(), Travel.class);
        mResponse mRes = basicService.queryForTravel(info);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
