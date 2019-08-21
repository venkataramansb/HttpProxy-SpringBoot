package Core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureClass {
    public int addNumbers(int i, int i1) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        int i2 = i + i1;
        System.out.println("FutureClass.addNumbers: " + Thread.currentThread().getName());
        Future future = executorService.submit(() ->addOnetoGivenNumber());
        int o = (int)future.get();
        return i2 + o;
    }

    private int addOnetoGivenNumber(){
        System.out.println("FutureClass.addOnetoGivenNumber: " + Thread.currentThread().getName());
        try {
            Thread.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
