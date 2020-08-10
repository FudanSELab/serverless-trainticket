package com.openfaas.function;


import com.openfaas.function.service.StationService;
import com.openfaas.function.service.StationServiceImpl;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

import java.util.List;


public class Handler implements com.openfaas.model.IHandler {

    private StationService stationService = new StationServiceImpl();

    public IResponse Handle(IRequest req) {
        List<String> info = JsonUtils.json2Object(req.getBody(), List.class);
        mResponse mRes = stationService.queryByIdBatch(info);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
