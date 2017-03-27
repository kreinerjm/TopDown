import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Created by jacob on 3/27/17.
 */
public class CassandraTest {


    public static void main(String[] args)
    {
        Cluster cluster;
        Session session;
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("top_down");
        ResultSet results = session.execute("SELECT * FROM player_by_y");
        for (Row row : results) {
            System.out.format("%s %d\n", row.getInt("player_x"), row.getInt("player_y"));
        }
    }
}
