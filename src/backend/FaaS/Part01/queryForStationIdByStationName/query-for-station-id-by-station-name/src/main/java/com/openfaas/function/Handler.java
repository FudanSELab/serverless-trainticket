package com.openfaas.function;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.service.StationService;
import com.openfaas.function.service.StationServiceImpl;
import com.openfaas.model.IHandler;
import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import org.bson.Document;


/**
 * FINISHED
 * function7
 * query-stationID-by-stationName
 * Http Method : GET
 * <p>
 * 原API地址："http://ts-station-service:12345/api/v1/stationservice/stations/id/" + stationName
 * <p>
 * 输入：(String)stationName
 * 输出：(String)stationID
 */

public class Handler implements com.openfaas.model.IHandler {

    private StationService stationService = new StationServiceImpl();

    public IResponse Handle(IRequest req) {

    	   System.out.println("start");
        MongoClient mongoClient = MongoClients.create("mongodb://ts-station-mongo.default:27017");
        MongoDatabase database = mongoClient.getDatabase("ts");
        MongoCollection<Document> collection = database.getCollection("station");
        System.out.println("success");





        
        String stationName = req.getPath().get("stationName");
        mResponse mRes = stationService.queryForId(stationName);

        Response res = new Response();
        res.setBody(JsonUtils.object2Json(mRes));

        return res;
    }
}
