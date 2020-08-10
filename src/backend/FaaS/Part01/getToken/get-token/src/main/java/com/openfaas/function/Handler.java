package com.openfaas.function;

import com.openfaas.function.dto.BasicAuthDto;
import com.openfaas.function.service.TokenService;
import com.openfaas.function.service.TokenServiceImpl;

import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;


import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * function1 queryInfo
 * FINISHED/UNTESTED
 * 根据用户输入返回符合条件的所有列车班次
 * get left trip tickets
 * Http Method : POST
 * <p>
 * 原API地址：ts-travel-service/api/v1/travelservice/trips/left
 * <p>
 * 输入：前端传来的json数据 转成的TripInfo对象
 * 输出：List<TripResponse>
 */

public class Handler implements com.openfaas.model.IHandler {

    private TokenService tokenService = new TokenServiceImpl();

    public IResponse Handle(IRequest req) {
        BasicAuthDto dao = JsonUtils.json2Object(req.getBody(), BasicAuthDto.class);
        mResponse mRes = tokenService.getToken(dao);

        IResponse res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        return res;
    }
}
