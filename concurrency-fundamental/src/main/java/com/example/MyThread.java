package com.example;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("current thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Main thread started.");

        MyThread thread = new MyThread();
        thread.start();
        thread.interrupt();

        System.out.println("main thread " + Thread.currentThread().getName());
    }
}