package Core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Core {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> call());
        System.out.println("111");
       // System.out.println("222"+completableFuture.get());
        System.out.println("333");
       completableFuture.get();
    }

    private static <String> java.lang.String call() {
        try {
            System.out.println("Inside");
            Thread.sleep(1000);
            System.out.println("Outside");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hi";
    }
}
