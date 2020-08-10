package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Payment;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class PaymentRepositoryImpl implements PaymentRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-payment-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("payment");

    @Override
    public Payment findByOrderId(String orderId) {
        Document resDoc = collection.find(eq("orderId", orderId)).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        Payment resPayment = JsonUtils.json2Object(resDoc.toJson(), Payment.class);
        return resPayment;
    }

    @Override
    public void save(Payment payment) {
        Document doc = new Document(JsonUtils.object2Map(payment));
        collection.insertOne(doc);
    }
}
