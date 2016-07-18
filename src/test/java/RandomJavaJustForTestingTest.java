import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by blessingorazulume on 7/18/16.
 */
public class RandomJavaJustForTestingTest {

    @Test
    public void testGetSum() throws Exception {

        RandomJavaJustForTesting random = new RandomJavaJustForTesting(3, 5);
        assertEquals (random.getSum(), 7);
    }
}