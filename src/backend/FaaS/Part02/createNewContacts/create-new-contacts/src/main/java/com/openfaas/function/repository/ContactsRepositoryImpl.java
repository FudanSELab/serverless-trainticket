package com.openfaas.function.repository;

import com.mongodb.client.*;
import com.openfaas.function.entity.Contacts;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

public class ContactsRepositoryImpl implements ContactsRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-contacts-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("contacts");

    @Override
    public ArrayList<Contacts> findByAccountId(UUID accountId) {
        ArrayList<Contacts> result = new ArrayList<>();
        Document tempDoc;
        MongoCursor<Document> cursor = collection.find(eq("accountId", accountId.toString())).iterator();
        try {
            while (cursor.hasNext()) {
                tempDoc = cursor.next();
                tempDoc.remove("_id");
                result.add(JsonUtils.json2Object(tempDoc.toJson(), Contacts.class));
            }
        } finally {
            cursor.close();
        }

        return result;
    }

    @Override
    public void save(Contacts contacts) {
        Document doc = new Document(JsonUtils.object2Map(contacts));
        collection.insertOne(doc);
    }
}
