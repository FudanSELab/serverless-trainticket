package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.SecurityConfig;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class SecurityRepositoryImpl implements SecurityRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-security-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("security");


    @Override
    public SecurityConfig findByName(String name) {
        Document resDoc = collection.find(eq("name", name)).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        SecurityConfig resSecurityConfig = JsonUtils.json2Object(resDoc.toJson(), SecurityConfig.class);
        return resSecurityConfig;
    }

}
