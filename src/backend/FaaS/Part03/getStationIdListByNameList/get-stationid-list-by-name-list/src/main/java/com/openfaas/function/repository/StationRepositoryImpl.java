package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.Station;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class StationRepositoryImpl implements StationRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-station-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("station");


    @Override
    public Station findById(String id){
        Document resDoc = collection.find(eq("id", id)).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        Station resStation = JsonUtils.json2Object(resDoc.toJson(), Station.class);
        return resStation;
    }

}
