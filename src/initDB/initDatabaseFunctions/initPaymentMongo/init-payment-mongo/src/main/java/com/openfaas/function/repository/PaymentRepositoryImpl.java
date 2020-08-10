package com.openfaas.function.repository;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.openfaas.function.entity.Payment;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

public class PaymentRepositoryImpl implements PaymentRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-payment-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("payment");


    @Override
    public boolean init(){
        try {
            Payment payment = new Payment();
            payment.setId("5ad7750ba68b49c0a8c035276b067701");
            payment.setOrderId("5ad7750b-a68b-49c0-a8c0-32776b067701");
            payment.setPrice("10000.0");
            payment.setUserId("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f");
            Document doc1 = new Document(JsonUtils.object2Map(payment));
            collection.insertOne(doc1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
