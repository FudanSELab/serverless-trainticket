package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Order;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

public class OrderRepositoryImpl implements OrderRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-order-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("order");

    @Override
    public ArrayList<Order> findByAccountId(UUID accountId) {
        ArrayList<Order> result = new ArrayList<>();
        Document tempDoc;
        MongoCursor<Document> cursor = collection.find(eq("accountId", accountId.toString())).iterator();
        try {
            while (cursor.hasNext()) {
                tempDoc = cursor.next();
                tempDoc.remove("_id");
                result.add(JsonUtils.json2Object(tempDoc.toJson(), Order.class));
            }
        } finally {
            cursor.close();
        }

        return result;
    }

}
