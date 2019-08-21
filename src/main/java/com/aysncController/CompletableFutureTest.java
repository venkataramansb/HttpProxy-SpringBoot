package com.aysncController;

import static org.junit.Assert.*;
import org.junit.Test;

public class CompletableFutureTest {
    @Test
    public void shouldAddNumbers(){
        CompletableFutureClass completableFutureClass = new CompletableFutureClass();
        int result = completableFutureClass.addTwoNumbers(9,10);

        assertEquals(0,result);

    }
}
