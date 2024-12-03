package org.comp301.AsynchronousProgramming;
import java.util.Random;

public class ParaDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        for (int num_threads = 1; num_threads <= 24; num_threads++) {
            int num_items = 1000000000;

            Thread[] workers = new Thread[num_threads];

            long start = System.nanoTime();
            for (int i = 0; i < num_threads; i++) {
                int num_per_thread = num_items / num_threads;
                workers[i] = new Thread(() -> {
                    int num_to_do = num_per_thread;
                    Random rnd = new Random();
                    for (int j = 0; j < num_to_do; j++) {
                        rnd.nextDouble();
                    }
                });
                workers[i].start();
            }

            for (Thread w : workers) {
                try {
                    w.join();
                } catch (InterruptedException e) {
                }
            }

            long end = System.nanoTime();

            System.out.println("Overall elapsed with " + num_threads + " threads: " + ((end - start) / 1e9) + " seconds");
        }
    }
}
