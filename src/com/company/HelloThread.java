package com.company;

public class HelloThread {

    public static void main(String[] args) {

        Thread helloThread = new Thread(() -> {
            while(true) {
                System.out.println("Hello world, go away");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        helloThread.start();

    }
}
