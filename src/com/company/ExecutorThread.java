package com.company;

import java.util.concurrent.*;


public class ExecutorThread {

    public static volatile boolean isShutdown = false;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future = executor.submit(() -> {
            print("Hello");
            print("Goodbye");
        });


        try {
            Thread.sleep(5_000);
            executor.shutdownNow();
            isShutdown = executor.isShutdown();
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException ignore){
            System.out.println("1");
            ignore.printStackTrace();
        }

    }


    static void print(String message) {
        try {
            for (int i=0; i<5; ++i) {
                System.out.println(message);
                if(isShutdown) {
                    break;
                }
                Thread.sleep(1_000);
            }
        } catch (InterruptedException ignore){
            System.out.println("2");
            ignore.printStackTrace();
        }
    }
}
