package com.openfaas.function.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.Contacts;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

public class ContactsRepositoryImpl implements ContactsRepository {

    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-contacts-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("contacts");


    @Override
    public Contacts findById(UUID id) {
        Document resDoc = collection.find(eq("id", id.toString())).first();
        if (resDoc == null)
            return null;
        resDoc.remove("_id");
        Contacts resContact = JsonUtils.json2Object(resDoc.toJson(), Contacts.class);
        return resContact;
    }
}
