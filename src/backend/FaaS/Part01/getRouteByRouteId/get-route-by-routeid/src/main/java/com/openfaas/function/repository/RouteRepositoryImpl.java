package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Route;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class RouteRepositoryImpl implements RouteRepository {
    private MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-route-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("route");

    @Override
    public Route findById(String id) {
        Document resDoc = collection.find(eq("id", id)).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        Route resRoute = JsonUtils.json2Object(resDoc.toJson(), Route.class);
        return resRoute;
    }
}
