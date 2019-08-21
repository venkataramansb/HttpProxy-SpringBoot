package com.aysncController;

import Core.ProcessorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class Demo {
    @Autowired
    RestTemplate restTemplate;

    public ProcessorData atlasCall(ProcessorData processorData) {
        System.out.println("Demo.atlasCall:" + Thread.currentThread().getName() + "---" + processorData.getSimNumber());
        CompletableFuture<ProcessorData> completableFuture = CompletableFuture.
                supplyAsync(() -> callSDN(processorData))
                .thenApplyAsync((data) -> callGetSimFromVodafone(processorData))
                .thenApplyAsync((output) -> callDeviceRegistartionFromVodafone(processorData))
                .whenComplete((value, throwable) -> responseConstructor(processorData, throwable));


        return completableFuture.join();
    }

    private ProcessorData responseConstructor(ProcessorData processorData) {
    return null;
    }
    //.exceptionally((throwable) -> exceptionOccur(throwable));
    //.handle((ex,data) -> processOuput(processorData,))


    private Object processOuput(ProcessorData processorData, Throwable exp) {
        System.out.println("Demo.processOuput:" + Thread.currentThread().getName());
        exp.getStackTrace();
        return null;
    }


    private ProcessorData exceptionOccur(Throwable ex) {
        System.out.println("Demo.exceptionOccur:" + Thread.currentThread().getName() + "---" + ex.getMessage());
        throw new NullPointerException();
    }

    private ProcessorData callSDN(ProcessorData processorData) {

        System.out.println("Demo.callSDN:" + Thread.currentThread().getName() + "---" + processorData.getSimNumber());

        if (processorData.getSimNumber().equalsIgnoreCase("3")) {
            throw new NullPointerException(processorData.getSimNumber());
        }
        return processorData;
    }

    private ProcessorData callGetSimFromVodafone(ProcessorData processorData) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Demo.callGetSimFromVodafone:" + Thread.currentThread().getName() + "---" + processorData.getSimNumber());

        return processorData;
    }

    private ProcessorData callDeviceRegistartionFromVodafone(ProcessorData processorData) {
        System.out.println("Demo.callDeviceRegistartionFromVodafone:" + Thread.currentThread().getName() + "---" + processorData.getSimNumber());
        return processorData;
    }

    private ProcessorData responseConstructor(ProcessorData processorData, Throwable throwable) {
      //  System.out.println("Demo.responseConstructor:" + Thread.currentThread().getName() + "---" + processorData.getSimNumber() + "---" + throwable.getMessage());
       // throw new NumberFormatException();
          return new ProcessorData("0099","F","123");
    }


    public void callVodafone() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer f890eaa7-4d06-3034-84dc-4b2da7d61ca0");
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters",httpHeaders);
        String uri ="https://stg.api.m2m.vodafone.com/m2m/v1/devices/204046856040517";
        //RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        System.out.println("Demo.callVodafone::"+stringResponseEntity.toString());
    }
}