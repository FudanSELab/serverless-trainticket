package com.openfaas.function.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.openfaas.function.entity.User;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-user-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("user");


    @Override
    public boolean init() {
        try {
            User user = new User(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"),
                    "fdse_microservice",
                    "111111",
                    1,
                    1,
                    "2135488099312X",
                    "fdse_microservice@163.com"
                    );
            Document doc1 = new Document(JsonUtils.object2Map(user));
            collection.insertOne(doc1);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
