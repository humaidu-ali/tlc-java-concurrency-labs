package com.company;

import java.util.Random;

public class Consumer extends Thread {

    private Letters pool;

    public Consumer(Letters pool, String name) {
        super(name);
        this.pool = pool;
    }

    @Override
    public void run() {
        char c;

        for (int i = 0; i < 10; i++) {

            c = this.pool.takeLetter();

            System.out.println("Thread " + this.getName() + " takes letter " + c);

            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }
}
