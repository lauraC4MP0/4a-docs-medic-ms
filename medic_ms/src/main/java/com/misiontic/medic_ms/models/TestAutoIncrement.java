package grupo2ciclo4.consulmedicms.models;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class TestAutoIncrement {

    private final static String DB_NAME = "MyTestDB";
    private final static String TEST_COLLECTION = "testCollection";
    private final static String COUNTERS_COLLECTION = "countersCollection";

    public static DBCollection testCollection;
    public static DBCollection countersCollection;

    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient();
            DB database = mongoClient.getDB(DB_NAME);
            testCollection = database.getCollection(TEST_COLLECTION);
            countersCollection = database.getCollection(COUNTERS_COLLECTION);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (countersCollection.count() == 0) {
            createCountersCollection();
        }

            createTestCollection();
    }

    public static void createCountersCollection() {

        BasicDBObject document = new BasicDBObject();
        document.append("_id", "userid");
        document.append("seq", 0);
        countersCollection.insert(document);
    }

    public static Object getNextSequence(String name) {

        BasicDBObject searchQuery = new BasicDBObject("_id", name);
        BasicDBObject increase = new BasicDBObject("seq", 1);
        BasicDBObject updateQuery = new BasicDBObject("$inc", increase);
        DBObject result = countersCollection.findAndModify(searchQuery, null, null,
                false, updateQuery, true, false);

        return result.get("seq");
    }
}
