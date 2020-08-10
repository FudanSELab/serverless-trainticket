package com.openfaas.function;

import com.openfaas.function.service.RouteService;
import com.openfaas.function.service.RouteServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * FINISHED
 * function3 getRouteByRouteId
 * 根据用户输入返回符合条件的所有列车班次
 * GET route info
 * Http Method : GET
 * <p>
 * 原API地址：http://ts-route-service:11178/api/v1/routeservice/routes/ + routeId
 * <p>
 * 输入：(String)RouteId
 * 输出：(Object)route
 */

public class Handler implements com.openfaas.model.IHandler {
    private RouteService routeService = new RouteServiceImpl();

    public IResponse Handle(IRequest req) {
        String routeId = req.getPath().get("routeId");

        mResponse mRes = routeService.getRouteById(routeId);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
