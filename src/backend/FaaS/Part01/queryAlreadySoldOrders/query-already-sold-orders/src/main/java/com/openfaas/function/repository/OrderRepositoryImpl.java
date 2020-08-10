package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Order;
import edu.fudan.common.util.DateUtils;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class OrderRepositoryImpl implements OrderRepository {
    private MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-order-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("order");


    String accountId = "4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f";
    String contactName = "Contacts_One";
    String contactDocumentNumber = "DocumentNumber_One";
    String firstClass = "FirstClass-30";
    String price = "100.0";

    @Override
    public ArrayList<Order> findByTravelDateAndTrainNumber(Date travelDate, String trainNumber) {
        ArrayList<Order> orders = new ArrayList<>();
        Document tempDoc;
        long travelDateL= DateUtils.dateToMillisecond(travelDate);
        MongoCursor<Document> cursor = collection.find(and(eq("travelDate", travelDateL), eq("trainNumber", trainNumber))).iterator();
        try {
            while (cursor.hasNext()) {
                tempDoc = cursor.next();
                tempDoc.remove("_id");
                orders.add(JsonUtils.json2Object(tempDoc.toJson(), Order.class));
            }
        } finally {
            cursor.close();
        }

        return orders;
//        ArrayList<Order> result = new ArrayList<>();
//        for (Order tempOrder : orders) {
//            if (tempOrder.getTravelDate().compareTo(travelDate) == 0 && tempOrder.getTrainNumber().equals(trainNumber)) {
//                result.add(tempOrder);
//            }
//        }
//        return result;
    }
}
