package com.example;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("child thread finished");
    }

    public static void main(String[] args) {

        System.out.println("Main thread started.");

        Thread a = new Thread(new MyRunnable());
        a.start();

        // Main thread continues execution
        System.out.println("Main thread finished.");
    }

}