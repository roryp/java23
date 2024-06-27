package com.example;

import java.util.concurrent.*;

public class StructuredConcurrency {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> future1 = scope.fork(() -> {
                return "Result 1";
            });
            Future<String> future2 = scope.fork(() -> {
                return "Result 2";
            });
            scope.join();
            scope.throwIfFailed();

            System.out.println(future1.resultNow() + ", " + future2.resultNow());
        }
    }
}