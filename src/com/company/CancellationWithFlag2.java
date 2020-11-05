package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancellationWithFlag2 {

    public static AtomicBoolean anotherIsRunning = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {


        Thread helloThread = new Thread(() -> {

            while(anotherIsRunning.get()) {
                System.out.println("Hello world, go away + is running " + anotherIsRunning.get());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        helloThread.start();

        Thread.sleep(5000);
        anotherIsRunning.set(false);
        System.out.println("Set is Running to " + anotherIsRunning.get());
    }
}
