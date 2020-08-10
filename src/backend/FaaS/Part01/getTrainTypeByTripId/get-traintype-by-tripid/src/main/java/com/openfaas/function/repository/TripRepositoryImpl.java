package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Trip;
import com.openfaas.function.entity.TripId;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;


public class TripRepositoryImpl implements TripRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-travel-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("travel");


    @Override
    public Trip findByTripId(TripId tripId) {
        MongoCursor<Document> cursor = collection.find().iterator();
        Document tempDoc;
        Trip resTrip = null;
        Document tempTripIdDoc;

        try {
            while (cursor.hasNext()) {
                tempDoc = cursor.next();
                tempTripIdDoc = (Document) tempDoc.get("tripId");
                if (tempTripIdDoc.get("type") .equals( tripId.getType().getName()) && tempTripIdDoc.get("number") .equals(tripId.getNumber())) {
                    tempDoc.remove("_id");
                    resTrip = JsonUtils.json2Object(tempDoc.toJson(), Trip.class);
                    break;
                }

            }
        } finally {
            cursor.close();
        }

        if (resTrip == null)
            return null;
        return resTrip;
    }

}

