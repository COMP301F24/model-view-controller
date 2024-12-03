package org.comp301.AsynchronousProgramming;

public class Multithreader {
  public static void main(String[] args) {
    Runnable task1 =
        () -> {
          for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
          }
        };

    System.out.println("Start");
    Thread thread = new Thread(task1);
    thread.start();
    Thread thread2 = new Thread(task1);
    thread2.start();
    try{
    //thread.join();
    thread2.join();
    }catch(InterruptedException e){
        System.out.println("Something bad happened");
    }
    System.out.println("End");

  }
}
