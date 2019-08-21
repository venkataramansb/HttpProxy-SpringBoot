package com.aysncController;

import Core.ProcessorData;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {
    ProcessorData processorData;

    @Before
    public void setup(){
        processorData = new ProcessorData("1212ASD","E","");
    }

    @Test
    public void testCompletableFuture(){
       // for (int i = 0;i<=10;i++) {
            new Demo().atlasCall(new ProcessorData("1212ASD", "E", String.valueOf(8)));

          //  System.out.println("DemoTest.testCompletableFuture:"+processorData.getVin()+"---"+processorData.getSimNumber()+"---"+processorData.getStatus());
        //}

    }
}
