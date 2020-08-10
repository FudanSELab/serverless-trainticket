package com.openfaas.function;

import com.openfaas.function.repository.TripRepositoryImpl;
import com.openfaas.function.service.TravelServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;

import com.openfaas.function.entity.*;
import com.openfaas.function.service.TravelService;


import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

import java.util.ArrayList;
import java.util.Date;


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

    private TravelService travelService = new TravelServiceImpl();

    public IResponse Handle(IRequest req) {
        TripInfo info = JsonUtils.json2Object(req.getBody(), TripInfo.class);
        mResponse mRes = travelService.query(info);

        IResponse res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Methods", "POST");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        return res;
    }
}
