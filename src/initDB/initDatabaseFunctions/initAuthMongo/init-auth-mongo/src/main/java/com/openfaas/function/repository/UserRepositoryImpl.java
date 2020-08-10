package com.openfaas.function.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.openfaas.function.entity.User;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-auth-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("user");


    @Override
    public boolean init() {
        try {
            User user1 = new User(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"),
                    "fdse_microservice",
                    "111111",
                    new HashSet<>(Arrays.asList("ROLE_USER"))
                    );
            Document doc1 = new Document(JsonUtils.object2Map(user1));
            collection.insertOne(doc1);

            User user2 = new User(UUID.randomUUID(),
                    "admin",
                    "222222",
                    new HashSet<>(Arrays.asList("ROLE_ADMIN"))
            );
            Document doc2 = new Document(JsonUtils.object2Map(user2));
            collection.insertOne(doc2);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
