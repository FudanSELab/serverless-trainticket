package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.Config;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class ConfigRepositoryImpl implements ConfigRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-config-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("config");

    @Override
    public Config findByName(String name) {
        Document resDoc = collection.find(eq("name", name)).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        Config resConfig = JsonUtils.json2Object(resDoc.toJson(), Config.class);
        return resConfig;
    }
}
