package com.openfaas.function.repository;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.openfaas.function.entity.Station;
import edu.fudan.common.util.JsonUtils;
import org.bson.Document;

import java.util.ArrayList;

public class StationRepositoryImpl implements StationRepository {
    MongoClient mongoClient = MongoClients.create("mongodb://ts-serverless-station-mongo.default:27017");
    private MongoDatabase database = mongoClient.getDatabase("ts");
    private MongoCollection<Document> collection = database.getCollection("station");

    private ArrayList<Station> stations = new ArrayList<>();

    @Override
    public boolean init(){
        try {
            Station info1 = new Station();
            info1.setId("shanghai");
            info1.setName("Shang Hai");
            info1.setStayTime(10);
            stations.add(info1);
            Document doc1 = new Document(JsonUtils.object2Map(info1));
            collection.insertOne(doc1);

            Station info2 = new Station();
            info2.setId("shanghaihongqiao");
            info2.setName("Shang Hai Hong Qiao");
            info2.setStayTime(10);
            Document doc2 = new Document(JsonUtils.object2Map(info2));
            collection.insertOne(doc2);

            Station info3 = new Station();
            info3.setId("taiyuan");
            info3.setName("Tai Yuan");
            info3.setStayTime(5);
            Document doc3 = new Document(JsonUtils.object2Map(info3));
            collection.insertOne(doc3);

            Station info4 = new Station();
            info4.setId("beijing");
            info4.setName("Bei Jing");
            info4.setStayTime(10);
            Document doc4 = new Document(JsonUtils.object2Map(info4));
            collection.insertOne(doc4);

            Station info5 = new Station();
            info5.setId("nanjing");
            info5.setName("Nan Jing");
            info5.setStayTime(8);
            Document doc5 = new Document(JsonUtils.object2Map(info5));
            collection.insertOne(doc5);

            Station info6 = new Station();
            info6.setId("shijiazhuang");
            info6.setName("Shi Jia Zhuang");
            info6.setStayTime(8);
            Document doc6 = new Document(JsonUtils.object2Map(info6));
            collection.insertOne(doc6);

            Station info7 = new Station();
            info7.setId("xuzhou");
            info7.setName("Xu Zhou");
            info7.setStayTime(7);
            Document doc7 = new Document(JsonUtils.object2Map(info7));
            collection.insertOne(doc7);

            Station info8 = new Station();
            info8.setId("jinan");
            info8.setName("Ji Nan");
            info8.setStayTime(5);
            Document doc8 = new Document(JsonUtils.object2Map(info8));
            collection.insertOne(doc8);

            Station info9 = new Station();
            info9.setId("hangzhou");
            info9.setName("Hang Zhou");
            info9.setStayTime(9);
            Document doc9 = new Document(JsonUtils.object2Map(info9));
            collection.insertOne(doc9);

            Station info10 = new Station();
            info10.setId("jiaxingnan");
            info10.setName("Jia Xing Nan");
            info10.setStayTime(2);
            Document doc10 = new Document(JsonUtils.object2Map(info10));
            collection.insertOne(doc10);

            Station info11 = new Station();
            info11.setId("zhenjiang");
            info11.setName("Zhen Jiang");
            info11.setStayTime(2);
            Document doc11 = new Document(JsonUtils.object2Map(info11));
            collection.insertOne(doc11);

            Station info12 = new Station();
            info12.setId("wuxi");
            info12.setName("Wu Xi");
            info12.setStayTime(3);
            Document doc12 = new Document(JsonUtils.object2Map(info12));
            collection.insertOne(doc12);

            Station info13 = new Station();
            info13.setId("suzhou");
            info13.setName("Su Zhou");
            info13.setStayTime(3);
            Document doc13 = new Document(JsonUtils.object2Map(info13));
            collection.insertOne(doc13);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
