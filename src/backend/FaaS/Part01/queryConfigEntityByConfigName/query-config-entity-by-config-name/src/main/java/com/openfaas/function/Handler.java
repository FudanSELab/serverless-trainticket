package com.openfaas.function;

import com.openfaas.function.service.ConfigService;
import com.openfaas.function.service.ConfigServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


/**
 * function12 queryConfigEntity
 *
 * query config entity by configName
 * Http Method : GET
 * <p>
 * 原API地址："http://ts-config-service:15679/api/v1/configservice/configs/" + configName
 * <p>
 * 输入：(String)configName
 * 输出：(Object)Config
 */

public class Handler implements com.openfaas.model.IHandler {

    private ConfigService configService = new ConfigServiceImpl();

    public IResponse Handle(IRequest req) {
        String configName = req.getPath().get("configName");
        mResponse mRes = configService.query(configName);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

	    return res;
    }
}
