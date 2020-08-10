package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.User;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.Optional;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class UserRepositoryImpl implements UserRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-auth-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("user");

    @Override
    public User findByUsername(String username) {
        Document resDoc = collection.find(eq("username", username)).first();
        if (resDoc == null)
            return null;

        resDoc.remove("_id");
        User resUser = JsonUtils.json2Object(resDoc.toJson(), User.class);
        return resUser;
    }


    @Override
    public User findByUsernameAndPassword(String username,String password) {
        Document resDoc = collection.find(and(eq("username", username),eq("password", password))).first();
        if (resDoc == null)
            return null;

        resDoc.remove("_id");
        User resUser = JsonUtils.json2Object(resDoc.toJson(), User.class);
        return resUser;
    }

}
