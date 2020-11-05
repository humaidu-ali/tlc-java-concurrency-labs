package com.company;

public class CancelWithInterrupt {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread 1");

        Thread helloThread = new Thread(() -> {

            while(true) {

                System.out.println("Hello world, go away");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
                }
            }
        });

        helloThread.start();

        Thread.sleep(5000);

        helloThread.interrupt();

        System.out.println("Main Thread 2");

    }
}
