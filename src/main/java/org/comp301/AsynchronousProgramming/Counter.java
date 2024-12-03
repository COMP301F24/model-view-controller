package org.comp301.AsynchronousProgramming;


public class Counter {
    private int value;

    public Counter() {
        value = 0;
    }

    public synchronized void   addOne() {
        value = getValue() + 1;
    }

    public synchronized void subtractOne() {
        value = getValue() - 1;
    }

    public synchronized  int getValue() {
        return value;
    }

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i=0; i<100000; i++) {
                counter.addOne();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i=0; i<100000; i++) {
                counter.subtractOne();
            }
        });

        System.out.println(counter.getValue());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println(counter.getValue());
    }
}
