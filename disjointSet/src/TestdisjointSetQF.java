import org.junit.Test;
import static org.junit.Assert.*;

public class TestdisjointSetQF {

    @Test
    public void TestConnect(){
        disjointSetQF jointset = new disjointSetQF(10);

        assertTrue(!jointset.isConnected(1,2));

        jointset.connect(1, 2);
        assertTrue(jointset.isConnected(1, 2));

        jointset.connect(1, 0);
        assertTrue(jointset.isConnected(0, 2));
    }
}
