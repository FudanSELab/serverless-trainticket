package com.openfaas.function.repository;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.*;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;


public class ConfigRepositoryImpl implements ConfigRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-config-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("config");

    @Override
    public boolean init(){
        try {
            Config config = new Config();

            config.setName("DirectTicketAllocationProportion");
            config.setValue("0.5");
            config.setDescription("Allocation Proportion Of The Direct Ticket - From Start To End");

            Document doc1 = new Document(JsonUtils.object2Map(config));
            collection.insertOne(doc1);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
