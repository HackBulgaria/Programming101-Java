package io.github.ivanvergiliev;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeAdder {
  private int sum = 0;

  public synchronized void increment() {
    ++sum;
  }

  public synchronized int getSum() {
    return sum;
  }

  public static class RunnableImpl implements Runnable {
    private ThreadSafeAdder adder;

    public RunnableImpl(ThreadSafeAdder adder) {
      this.adder = adder;
    }

    public void run() {
      for (int i = 0; i < 1000; ++i) {
        adder.increment();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = new ArrayList<>();
    ThreadSafeAdder adder = new ThreadSafeAdder();
    for (int i = 0; i < 100; ++i) {
      Thread t = new Thread(new RunnableImpl(adder));
      t.start();
      threads.add(t);
    }
    for (Thread t : threads) {
      t.join();
    }
    System.out.println(adder.getSum());
  }
}
