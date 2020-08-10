package com.openfaas.function.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.SecurityConfig;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

public class SecurityRepositoryImpl implements SecurityRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-security-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("security");


    @Override
    public boolean init() {
        try {
            SecurityConfig info1 = new SecurityConfig();
            info1.setName("max_order_1_hour");
            info1.setValue(Integer.MAX_VALUE + "");
            info1.setDescription("Max in 1 hour");
            Document doc1 = new Document(JsonUtils.object2Map(info1));
            collection.insertOne(doc1);

            SecurityConfig info2 = new SecurityConfig();
            info2.setName("max_order_not_use");
            info2.setValue(Integer.MAX_VALUE + "");
            info2.setDescription("Max not used");
            Document doc2 = new Document(JsonUtils.object2Map(info2));
            collection.insertOne(doc2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
