package com.example;

public class VolatileWithoutSynchronization {
    private long counter = 0;

    public synchronized void increaseCounter() {
        System.out.println(Thread.currentThread().getName());
        counter++;
    }

    public static void main(String[] args) {
        var example = new VolatileWithoutSynchronization();



        var thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                example.increaseCounter();
            }
        });

        thread1.start();

        for (int i = 0; i < 1000; i++) {
            example.increaseCounter();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("the counter now is " + example.counter);

    }
}
