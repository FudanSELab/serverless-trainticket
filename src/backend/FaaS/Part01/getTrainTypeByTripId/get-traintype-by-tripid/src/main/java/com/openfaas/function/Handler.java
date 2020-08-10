package com.openfaas.function;

import com.openfaas.function.service.TravelService;
import com.openfaas.function.service.TravelServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * function11 getTrainTypeByTripId
 *
 * get train type by tripId
 * Http Method : GET
 * <p>
 * 原API地址： "http://ts-travel-service:12346/api/v1/travelservice/train_types/{tripId}
 * <p>
 * 输入：(String)tripId
 * 输出：(Object)TrainType
 */
public class Handler implements com.openfaas.model.IHandler {

    private TravelService travelService = new TravelServiceImpl();

    public IResponse Handle(IRequest req) {

        String tripId = req.getPath().get("tripId");
        mResponse mRes = travelService.getTrainTypeByTripId(tripId);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

	    return res;
    }
}
