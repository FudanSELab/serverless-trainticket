package com.openfaas.function;

import com.openfaas.function.entity.TrainType;
import com.openfaas.function.service.TrainService;
import com.openfaas.function.service.TrainServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * function4 queryTrainType
 * FINISHED/UNTESTED
 * <p>
 * get train's info by id
 * Http Method : GET
 * <p>
 * 原API地址："http://ts-train-service:14567/api/v1/trainservice/trains/" + trainTypeId
 * <p>
 * 输入：(String)trainTypeId
 * 输出：(Object)TrainType(查不到的的话返回输入的ID)
 */


public class Handler implements com.openfaas.model.IHandler {
    private TrainService trainService = new TrainServiceImpl();

    public IResponse Handle(IRequest req) {

        String trainTypeId = req.getPath().get("trainTypeId");

        TrainType trainType = trainService.retrieve(trainTypeId);
        mResponse mRes;

        if (trainType == null) {
            mRes=new mResponse(0, "here is no TrainType with the trainType id", trainTypeId);
        } else {
            mRes=new mResponse(1, "success", trainType);
        }

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
