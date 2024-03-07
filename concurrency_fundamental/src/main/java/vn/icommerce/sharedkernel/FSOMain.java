package vn.icommerce.sharedkernel;

public class FSOMain {
    private static final int MAX_TRANSFERS = 1_000;

    public static void main(String[] args) throws InterruptedException {
        FSOAccount a = new FSOAccount(10_000);
        FSOAccount b = new FSOAccount(10_000);
        Thread tA = new Thread(() -> {
            for (int i = 0; i < MAX_TRANSFERS; i = i + 1) {
                boolean ok = a.transferTo(b, 1);
                if (!ok) {
                    System.out.println("Thread A failed at "+ i);
                }
                System.out.println("Thread A ok at "+ i);
            }
        });
        Thread tB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread B waked");

            for (int i = 0; i < MAX_TRANSFERS; i = i + 1) {
                boolean ok = b.transferTo(a, 1);
                if (!ok) {
                    System.out.println("Thread B failed at "+ i);
                }
                System.out.println("Thread B ok at "+ i);
            }
        });
        tA.start();
        tB.start();
        tA.join();
        tB.join();

        System.out.println("Finished: "+ a.getBalance() + " : "+ b.getBalance());
    }
}
