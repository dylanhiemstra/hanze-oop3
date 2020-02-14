package week1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedSum {
    public Integer sum = 0;

    public SynchronizedSum() {
        ExecutorService pool = Executors.newFixedThreadPool(1000);

        for(int i = 0; i < 1000; i++) {
            pool.submit(new Runnable() {
                public void run() {
                    synchronized (sum) {
                        sum++;
                    }
                }
            });
        }

        pool.shutdown();
        System.out.println(sum);
    }
}
