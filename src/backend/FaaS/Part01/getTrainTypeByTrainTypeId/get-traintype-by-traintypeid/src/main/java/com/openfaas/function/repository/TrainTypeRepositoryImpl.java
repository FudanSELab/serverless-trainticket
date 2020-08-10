package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.TrainType;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class TrainTypeRepositoryImpl implements TrainTypeRepository {

    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-train-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("train");


    public TrainType findById(String id) {
        Document resDoc = collection.find(eq("id", id)).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        TrainType resTrainType = JsonUtils.json2Object(resDoc.toJson(), TrainType.class);
        return resTrainType;
    }
}
