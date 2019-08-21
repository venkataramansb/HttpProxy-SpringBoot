package Core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CompletableTest {
    CompletableDemo completableDemo = null;
    ProcessorData processorData = null;
    @Before
    public void setup(){
      completableDemo = new CompletableDemo();
      processorData = new ProcessorData("WEW23432423","EV");
    }
//Async -> Thread
  @Test
  public void checkCompletableCreated(){
        completableDemo.checkSimIntiated(processorData);
      //  assertTrue();
  }
}
