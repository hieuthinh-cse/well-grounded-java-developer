package vn.icommerce.sharedkernel;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("current thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("???");
        }

        if(Thread.interrupted()) {
            System.out.println("interrupted");
        }

        System.out.println("ended");
    }
    public static void main(String[] args) {
        System.out.println("Main thread started.");

        MyThread thread = new MyThread();
        thread.start();
        thread.interrupt();

        System.out.println("main thread " + Thread.currentThread().getName());
    }
}