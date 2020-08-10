package com.openfaas.function.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.TrainType;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

public class TrainTypeRepositoryImpl implements TrainTypeRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-train-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("train");


    @Override
    public boolean init() {
        try {
            TrainType info1 = new TrainType();
            info1.setId("GaoTieOne");
            info1.setConfortClass(Integer.MAX_VALUE);
            info1.setEconomyClass(Integer.MAX_VALUE);
            info1.setAverageSpeed(250);
            Document doc1 = new Document(JsonUtils.object2Map(info1));
            collection.insertOne(doc1);

            TrainType info2 = new TrainType();
            info2.setId("GaoTieTwo");
            info2.setConfortClass(Integer.MAX_VALUE);
            info2.setEconomyClass(Integer.MAX_VALUE);
            info2.setAverageSpeed(200);
            Document doc2 = new Document(JsonUtils.object2Map(info2));
            collection.insertOne(doc2);

            TrainType info3 = new TrainType();
            info3.setId("DongCheOne");
            info3.setConfortClass(Integer.MAX_VALUE);
            info3.setEconomyClass(Integer.MAX_VALUE);
            info3.setAverageSpeed(180);
            Document doc3 = new Document(JsonUtils.object2Map(info3));
            collection.insertOne(doc3);

            TrainType info4 = new TrainType();
            info4.setId("ZhiDa");
            info4.setConfortClass(Integer.MAX_VALUE);
            info4.setEconomyClass(Integer.MAX_VALUE);
            info4.setAverageSpeed(120);
            Document doc4 = new Document(JsonUtils.object2Map(info4));
            collection.insertOne(doc4);

            TrainType info5 = new TrainType();
            info5.setId("TeKuai");
            info5.setConfortClass(Integer.MAX_VALUE);
            info5.setEconomyClass(Integer.MAX_VALUE);
            info5.setAverageSpeed(120);
            Document doc5 = new Document(JsonUtils.object2Map(info5));
            collection.insertOne(doc5);

            TrainType info6 = new TrainType();
            info6.setId("KuaiSu");
            info6.setConfortClass(Integer.MAX_VALUE);
            info6.setEconomyClass(Integer.MAX_VALUE);
            info6.setAverageSpeed(90);
            Document doc6 = new Document(JsonUtils.object2Map(info6));
            collection.insertOne(doc6);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
