package vn.icommerce.sharedkernel;

public class MyRunnable {
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1_000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

                System.out.println("child thread finished");
            }
        };

        System.out.println("Main thread started.");

        Thread a = new Thread(r);
        a.start();

        // Main thread continues execution
        System.out.println("Main thread finished.");
    }
}