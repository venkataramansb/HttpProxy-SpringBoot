package Core;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableDemo {

    public void checkSimIntiated(ProcessorData processorData) {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> simRepoCall());
    }

    private Supplier simRepoCall() {
    return null;
    }

}
