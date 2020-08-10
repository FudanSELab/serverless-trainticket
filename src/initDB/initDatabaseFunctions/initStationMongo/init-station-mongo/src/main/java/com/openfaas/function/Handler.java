package com.openfaas.function;

import com.openfaas.function.repository.StationRepository;
import com.openfaas.function.repository.StationRepositoryImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;


public class Handler implements com.openfaas.model.IHandler {

    private StationRepository stationRepository = new StationRepositoryImpl();

    public IResponse Handle(IRequest req) {
        Response res = new Response();

        if (stationRepository.init()) {
            res.setBody("Success");
        }

        return res;
    }
}
