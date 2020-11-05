package com.company;

import java.util.Random;

public class Producer extends Thread {

    private Letters pool;
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Producer(Letters pool, String name) {
        super(name);
        this.pool = pool;
    }


    @Override
    public void run() {
        char c;

        for (int i = 0; i < 10; i++) {
            int randomNumber = new Random().nextInt(26);
            c = ALPHABETS.charAt(randomNumber);
            this.pool.addLetter(c);

            System.out.println("Thread " + this.getName() + " added " + c);

            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
            }
        }
    }
}
