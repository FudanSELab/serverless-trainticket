package com.openfaas.function.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.AccountInfo;
import com.openfaas.function.entity.Money;
import com.openfaas.function.entity.MoneyType;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

public class AddMoneyRepositoryImpl implements AddMoneyRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-inside-payment-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("account");


    @Override
    public boolean init() {
        try {
            AccountInfo info1 = new AccountInfo();
            info1.setUserId("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f");
            info1.setMoney("10000");
            createAccount(info1);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void createAccount(AccountInfo info) {
        Money addMoney = new Money();
        addMoney.setMoney(info.getMoney());
        addMoney.setUserId(info.getUserId());
        addMoney.setType(MoneyType.A);
        Document doc1 = new Document(JsonUtils.object2Map(addMoney));
        collection.insertOne(doc1);

    }

}
