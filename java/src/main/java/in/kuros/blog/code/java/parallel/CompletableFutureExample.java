package in.kuros.blog.code.java.parallel;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CompletableFuture<Integer> service1 = CompletableFuture.supplyAsync(() -> slowService(1));
        final CompletableFuture<Integer> service2 = CompletableFuture.supplyAsync(() -> slowService(2));
        final CompletableFuture<Integer> service3 = CompletableFuture.supplyAsync(() -> slowService(3));

        CompletableFuture.allOf(service1, service2, service3).get();

        final int value = service1.get() + service2.get() + service3.get();

        System.out.println(value);
    }

    private static Integer slowService(final int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return i;
    }
}
