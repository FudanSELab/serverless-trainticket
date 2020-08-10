package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.PriceConfig;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class PriceConfigRepositoryImpl implements PriceConfigRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-price-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("price");

    @Override
    public PriceConfig findByRouteIdAndTrainType(String routeId, String trainType) {
        Document resDoc = collection.find(and(eq("routeId", routeId), eq("trainType", trainType))).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        PriceConfig resPriceConfig = JsonUtils.json2Object(resDoc.toJson(), PriceConfig.class);
        return resPriceConfig;
    }
}
