package com.openfaas.function;

import com.openfaas.function.entity.Route;
import com.openfaas.function.service.TravelService;
import com.openfaas.function.service.TravelServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * function9 getRouteByTripId
 * <p>
 * get route by tripId
 * Http Method : GET
 * <p>
 * 原API地址： "http://ts-travel-service:12346/api/v1/travelservice/routes/" + trainNumber,
 * <p>
 * 输入：(String)tripId
 * 输出：(Object)Route
 */

public class Handler implements com.openfaas.model.IHandler {

    private TravelService travelService = new TravelServiceImpl();

    public IResponse Handle(IRequest req) {

        String trainNumber = req.getPath().get("tripId");
        mResponse mRes = travelService.getRouteByTripId(trainNumber);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
