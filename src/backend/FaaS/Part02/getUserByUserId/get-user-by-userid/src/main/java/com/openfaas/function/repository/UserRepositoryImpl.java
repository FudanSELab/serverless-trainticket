package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.User;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

public class UserRepositoryImpl implements UserRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-user-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("user");

    @Override
    public User findByUserId(UUID userId) {
        Document resDoc = collection.find(eq("userId", userId.toString())).first();
        if (resDoc == null)
            return null;

        resDoc.remove("_id");
        User resUser = JsonUtils.json2Object(resDoc.toJson(), User.class);
        return resUser;
    }

}
