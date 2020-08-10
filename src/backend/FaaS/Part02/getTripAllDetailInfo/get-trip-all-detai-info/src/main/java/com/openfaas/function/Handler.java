package com.openfaas.function;

import com.openfaas.function.entity.*;
import com.openfaas.function.entity.TripInfo;
import com.openfaas.function.service.TravelService;
import com.openfaas.function.service.TravelServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

public class Handler implements com.openfaas.model.IHandler {

    private TravelService travelService = new TravelServiceImpl();

    public IResponse Handle(IRequest req) {
        TripAllDetailInfo info= JsonUtils.json2Object(req.getBody(),TripAllDetailInfo.class);
        mResponse mRes = travelService.getTripAllDetailInfo(info);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

	    return res;
    }
}
