package io.github.ivanvergiliev;

import java.util.concurrent.atomic.AtomicLongArray;

public class FalseSharing {
  private static final long MAX_ITER = 20_000_000L;

  private static AtomicLongArray arr = new AtomicLongArray(100);

  public static class Incrementer implements Runnable {
    private int index;

    public Incrementer(int index) {
      this.index = index;
    }

    public void run() {
      for (long i = 0; i < MAX_ITER; ++i) {
        arr.addAndGet(index, i);
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    while (true) {
      // False sharing.
      System.out.println("False sharing execution time: " + runtimeForPositions(0, 1));

      // No false sharing.
      System.out.println("Actual execution time: " + runtimeForPositions(20, 80));
    }
  }

  private static double runtimeForPositions(int p1, int p2) throws InterruptedException {
    long startTime = System.nanoTime();
    Thread t1 = new Thread(new Incrementer(p1));
    Thread t2 = new Thread(new Incrementer(p2));
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(arr.get(p1) + arr.get(p2));
    return (System.nanoTime() - startTime) / 1e9;
  }
}
