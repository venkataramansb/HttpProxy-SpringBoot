package com.aysncController;

import Core.ProcessorData;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureClass {
    public int addTwoNumbers(int i, int i1) {
        ExecutorService executor = Executors.newFixedThreadPool(4,
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        Thread t = Executors.defaultThreadFactory().newThread(r);
                        t.setDaemon(false);
                        System.out.println("thread created");
                        return t;
                    }
                });


        //  CompletableFuture completableFutures = CompletableFuture.supplyAsync(() -> addOneOutput(), Executors.newFixedThreadPool(10));
        int i2 = i + i1;
        System.out.println("CompletableFutureClass.addTwoNumbers:"+Thread.currentThread().getName());
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> callSDN("12DSFASA"),executor)
                .exceptionally((ex) -> exceptionOccur(ex))
                .thenApplyAsync((data) -> vodafoneGetSim(data))
                .thenApplyAsync((datas) -> printData(datas));
        try {
            completableFuture.get();
        }catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread end");

        return 0;
    }

    private String exceptionOccur(Throwable data) {
        System.out.println("CompletableFutureClass.exceptionOccur:"+data);
       throw new NullPointerException();
    }

    private String printData(ProcessorData datas) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println("data datas= [" + datas + "]");
        System.out.println("CompletableFutureClass.printData:"+Thread.currentThread().getName());
        return "Success";
    }

    private String callSDN(String processorData) {
        System.out.println("CompletableFutureClass.callSDN:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if("12DSFASAS".equalsIgnoreCase(processorData))
        throw new NullPointerException();
        return "SIM123";
    }

    private ProcessorData vodafoneGetSim(String data) {
        System.out.println("CompletableFutureClass.vodafoneGetSim:"+Thread.currentThread().getName());
     //   System.out.println("data = [" + data + "]");
       // System.out.println("CompletableFutureClass.vodafoneGetSim"+data);
        return new ProcessorData(data,"E");
    }


}
