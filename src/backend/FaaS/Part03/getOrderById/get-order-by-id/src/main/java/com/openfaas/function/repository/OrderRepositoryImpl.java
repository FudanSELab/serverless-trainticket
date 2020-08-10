package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
    public Order findById(UUID id) {
        Document resDoc = collection.find(eq("id", id.toString())).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        Order resOrder = JsonUtils.json2Object(resDoc.toJson(), Order.class);
        return resOrder;
    }

}
