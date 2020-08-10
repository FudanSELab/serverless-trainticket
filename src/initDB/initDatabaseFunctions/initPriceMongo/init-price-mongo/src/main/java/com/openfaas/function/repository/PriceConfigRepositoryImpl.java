package com.openfaas.function.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.*;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.UUID;

public class PriceConfigRepositoryImpl implements PriceConfigRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-price-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("price");

    String gaoTieOne = "GaoTieOne";
    String zhiDa = "ZhiDa";

    @Override
    public boolean init() {
        try {
            PriceConfig priceConfig1 = new PriceConfig();
            priceConfig1.setId(UUID.fromString("6d20b8cb-039c-474c-ae25-b6177ea41152"));
            priceConfig1.setRouteId("92708982-77af-4318-be25-57ccb0ff69ad");
            priceConfig1.setTrainType(gaoTieOne);
            priceConfig1.setBasicPriceRate(0.38);
            priceConfig1.setFirstClassPriceRate(1.0);
            Document doc1 = new Document(JsonUtils.object2Map(priceConfig1));
            collection.insertOne(doc1);

            PriceConfig priceConfig2 = new PriceConfig();
            priceConfig2.setId(UUID.fromString("c5679b7e-4a54-4f52-9939-1ae86ba16fa7"));
            priceConfig2.setRouteId("aefcef3f-3f42-46e8-afd7-6cb2a928bd3d");
            priceConfig2.setTrainType(gaoTieOne);
            priceConfig2.setBasicPriceRate(0.5);
            priceConfig2.setFirstClassPriceRate(1.0);
            Document doc2 = new Document(JsonUtils.object2Map(priceConfig2));
            collection.insertOne(doc2);

            PriceConfig priceConfig3 = new PriceConfig();
            priceConfig3.setId(UUID.fromString("719287d6-d3e7-4b54-9a92-71d039748b22"));
            priceConfig3.setRouteId("a3f256c1-0e43-4f7d-9c21-121bf258101f");
            priceConfig3.setTrainType(gaoTieOne);
            priceConfig3.setBasicPriceRate(0.7);
            priceConfig3.setFirstClassPriceRate(1.0);
            Document doc3 = new Document(JsonUtils.object2Map(priceConfig3));
            collection.insertOne(doc3);

            PriceConfig priceConfig4 = new PriceConfig();
            priceConfig4.setId(UUID.fromString("7de18cf8-bb17-4bb2-aeb4-85d8176d3a93"));
            priceConfig4.setRouteId("084837bb-53c8-4438-87c8-0321a4d09917");
            priceConfig4.setTrainType("GaoTieTwo");
            priceConfig4.setBasicPriceRate(0.6);
            priceConfig4.setFirstClassPriceRate(1.0);
            Document doc4 = new Document(JsonUtils.object2Map(priceConfig4));
            collection.insertOne(doc4);

            PriceConfig priceConfig5 = new PriceConfig();
            priceConfig5.setId(UUID.fromString("d5c4523a-827c-468c-95be-e9024a40572e"));
            priceConfig5.setRouteId("f3d4d4ef-693b-4456-8eed-59c0d717dd08");
            priceConfig5.setTrainType("DongCheOne");
            priceConfig5.setBasicPriceRate(0.45);
            priceConfig5.setFirstClassPriceRate(1.0);
            Document doc5 = new Document(JsonUtils.object2Map(priceConfig5));
            collection.insertOne(doc5);

            PriceConfig priceConfig6 = new PriceConfig();
            priceConfig6.setId(UUID.fromString("b90a6ad7-ffad-4624-9655-48e9e185fa6c"));
            priceConfig6.setRouteId("0b23bd3e-876a-4af3-b920-c50a90c90b04");
            priceConfig6.setTrainType(zhiDa);
            priceConfig6.setBasicPriceRate(0.35);
            priceConfig6.setFirstClassPriceRate(1.0);
            Document doc6 = new Document(JsonUtils.object2Map(priceConfig6));
            collection.insertOne(doc6);

            PriceConfig priceConfig7 = new PriceConfig();
            priceConfig7.setId(UUID.fromString("8fb01829-393f-4af4-9e96-f72866f94d14"));
            priceConfig7.setRouteId("9fc9c261-3263-4bfa-82f8-bb44e06b2f52");
            priceConfig7.setTrainType(zhiDa);
            priceConfig7.setBasicPriceRate(0.35);
            priceConfig7.setFirstClassPriceRate(1.0);
            Document doc7 = new Document(JsonUtils.object2Map(priceConfig7));
            collection.insertOne(doc7);

            PriceConfig priceConfig8 = new PriceConfig();
            priceConfig8.setId(UUID.fromString("8b059dc5-01a2-4f8f-8f94-6c886b38bb34"));
            priceConfig8.setRouteId("d693a2c5-ef87-4a3c-bef8-600b43f62c68");
            priceConfig8.setTrainType(zhiDa);
            priceConfig8.setBasicPriceRate(0.32);
            Document doc8 = new Document(JsonUtils.object2Map(priceConfig8));
            collection.insertOne(doc8);

            PriceConfig priceConfig9 = new PriceConfig();
            priceConfig9.setId(UUID.fromString("dd0e572e-7443-420c-8280-7d8215636069"));
            priceConfig9.setRouteId("20eb7122-3a11-423f-b10a-be0dc5bce7db");
            priceConfig9.setTrainType("TeKuai");
            priceConfig9.setBasicPriceRate(0.30);
            priceConfig9.setFirstClassPriceRate(1.0);
            Document doc9 = new Document(JsonUtils.object2Map(priceConfig9));
            collection.insertOne(doc9);

            PriceConfig priceConfig10 = new PriceConfig();
            priceConfig10.setId(UUID.fromString("0eb474c9-f8be-4119-8681-eb538a404a6a"));
            priceConfig10.setRouteId("1367db1f-461e-4ab7-87ad-2bcc05fd9cb7");
            priceConfig10.setTrainType("KuaiSu");
            priceConfig10.setBasicPriceRate(0.2);
            priceConfig10.setFirstClassPriceRate(1.0);
            Document doc10 = new Document(JsonUtils.object2Map(priceConfig10));
            collection.insertOne(doc10);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
