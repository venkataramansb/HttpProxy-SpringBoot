package Core;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableCore {

    public static void main(String[] args) {
  ProcessorData processorData =new ProcessorData("12asdfsfsf","Ecall");

        CompletableFuture completableFuture = CompletableFuture.
                supplyAsync(() -> simCall(processorData))
                .exceptionally((e) -> throwNewException(e))
                .thenApply((supplierData) -> rangeCheck(supplierData));


    }

    private static Supplier throwNewException(Throwable e) {
        System.out.println("Inside Exception");
   return throwNewException(new NullPointerException());
    }

    private static Object rangeCheck(Supplier<ProcessorData> supplierData) {
        System.out.println("RangeCheck");
        ProcessorData processorData = supplierData.get();
        System.out.println(processorData.getVin());
        return null;
    }

    private static Supplier simCall(ProcessorData processorDataSupplier) {
        System.out.println("Sim Call");
        Supplier<ProcessorData> dataSupplier = () -> {return new ProcessorData("sfdd00","EV");};

         return dataSupplier;
    }



}
