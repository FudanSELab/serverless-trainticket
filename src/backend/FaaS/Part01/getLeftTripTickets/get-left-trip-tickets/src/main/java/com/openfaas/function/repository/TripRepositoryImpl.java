package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Trip;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.ArrayList;

public class TripRepositoryImpl implements TripRepository {

    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-travel-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("travel");


    @Override
    public ArrayList<Trip> findAll() {
        ArrayList<Trip> result = new ArrayList<>();

        Document tempDoc;
        MongoCursor<Document> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
                tempDoc=cursor.next();
                tempDoc.remove("_id");
                result.add(JsonUtils.json2Object(tempDoc.toJson(), Trip.class));
            }
        } finally {
            cursor.close();
        }

        return result;
    }
}
