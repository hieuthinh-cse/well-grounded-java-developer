package com.example;

public class LifecycleWithInterrupt extends Thread{

    @Override
    public void run() {
        var start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var thisThread = Thread.currentThread();
        System.out.println(thisThread.getName() +
                " slept for "+ (System.currentTimeMillis() - start));
        if (thisThread.isInterrupted()) {
            System.out.println("Thread "+ thisThread.getName() +" was interrupted");
        }
    }


    public static void main(String[] args) throws InterruptedException {

        var t = new LifecycleWithInterrupt();

        t.setName("Worker");
        t.start();
        Thread.sleep(100);
        t.interrupt();
        t.join();
        System.out.println("Exiting");
    }
}
