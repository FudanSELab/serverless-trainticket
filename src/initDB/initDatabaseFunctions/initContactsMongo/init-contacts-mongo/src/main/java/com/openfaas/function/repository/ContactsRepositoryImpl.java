package com.openfaas.function.repository;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.Contacts;
import com.openfaas.function.entity.DocumentType;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.UUID;

public class ContactsRepositoryImpl implements ContactsRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-contacts-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("contacts");


    @Override
    public boolean init(){
        try {
            Contacts contactsOne = new Contacts();
            contactsOne.setAccountId(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"));
            contactsOne.setDocumentType(DocumentType.ID_CARD.getCode());
            contactsOne.setName("Contacts_One");
            contactsOne.setDocumentNumber("DocumentNumber_One");
            contactsOne.setPhoneNumber("ContactsPhoneNum_One");
            contactsOne.setId(UUID.fromString("90d357c6-b31e-49b8-8b1e-f33f5e51ccef"));
            Document doc1 = new Document(JsonUtils.object2Map(contactsOne));
            collection.insertOne(doc1);

            Contacts contactsTwo = new Contacts();
            contactsTwo.setAccountId(UUID.fromString("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f"));
            contactsTwo.setDocumentType(DocumentType.ID_CARD.getCode());
            contactsTwo.setName("Contacts_Two");
            contactsTwo.setDocumentNumber("DocumentNumber_Two");
            contactsTwo.setPhoneNumber("ContactsPhoneNum_Two");
            contactsTwo.setId(UUID.fromString("9e0b2927-67fa-4bd1-8198-cdad5c762289"));
            Document doc2 = new Document(JsonUtils.object2Map(contactsTwo));
            collection.insertOne(doc2);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
