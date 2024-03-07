package vn.icommerce.sharedkernel;

public class SynchronizationWithoutVolatile {
    private boolean flag = false;

    public void setFlag() {
        flag = true;
        System.out.println("the flag is now " + flag);
    }

    public void waitForFlag() {
        long count = 0;
        while (!flag) {
            count++;
//            System.out.println("keep going " + count);
        }
        System.out.println("Thread terminated with " + count);
    }

    public static void main(String[] args) {
        var example = new SynchronizationWithoutVolatile();

        // Thread 2 - waits for the flag
        new Thread(() -> {
            example.waitForFlag();
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        example.setFlag();
    }
}
