package week1;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.DoubleStream;

public class ParallelSum {
    public static void main(String[] args) {
        // Create a list
        final int N = 10000;
        double[] list = new double[N];
        Arrays.fill(list, 1);

        long startTime = System.currentTimeMillis();
        System.out.println("\nThe sum  is " + parallelSum(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Number of processors is " +
                Runtime.getRuntime().availableProcessors());
        System.out.println("Time with " + (endTime - startTime)
                + " milliseconds");
    }

    public static double parallelSum(double[] list) {
        RecursiveTask<Double> task = new RecursiveSum(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class RecursiveSum extends RecursiveTask<Double> {
        private final static int THRESHOLD = 1000;

        private double[] list;
        private int low;
        private int high;

        public RecursiveSum(double[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected Double compute() {
            if(high - low < THRESHOLD) {
                double total = 0d;
                for (int i = low; i < high; i++) {
                    total += this.list[i];
                }

                return total;
            } else {
                int mid = (low + high) / 2;
                RecursiveTask<Double> left = new RecursiveSum(list, low, mid);
                RecursiveTask<Double> right = new RecursiveSum(list, mid, high);

                right.fork();
                left.fork();

                return right.join() + left.join();
            }
        }
    }
}
