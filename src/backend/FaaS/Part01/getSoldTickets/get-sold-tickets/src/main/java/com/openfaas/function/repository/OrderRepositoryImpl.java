package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Order;
import edu.fudan.common.util.DateUtils;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class OrderRepositoryImpl implements OrderRepository {

    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-order-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("order");


    @Override
    public ArrayList<Order> findByTravelDateAndTrainNumber(Date travelDate, String trainNumber) {
        ArrayList<Order> result = new ArrayList<>();

        Document tempDoc;
        long travelDateL= DateUtils.dateToMillisecond(travelDate);
        MongoCursor<Document> cursor = collection.find(and(eq("travelDate", travelDateL), eq("trainNumber", trainNumber))).iterator();
        try {
            while (cursor.hasNext()) {
                tempDoc=cursor.next();
                tempDoc.remove("_id");
                result.add(JsonUtils.json2Object(tempDoc.toJson(), Order.class));
            }
        } finally {
            cursor.close();
        }

        return result;
    }
}
