package Core;

import static org.junit.Assert.*;
import org.junit.Test;

public class FutureTest {

    @Test
    public void checkFutureMethodCalled() throws Exception {
        FutureClass futureClass = new FutureClass();
        int result =futureClass.addNumbers(9,18);
        assertEquals(28,result);
    }
}
