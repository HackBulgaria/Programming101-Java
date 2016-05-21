package io.github.ivanvergiliev;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ThreadSafeFibonacciAdder {
  private int sum = 0;

  public void add(int pos) {
    int a = 1;
    int b = 1;
    for (int n = 3; n <= pos; ++n) {
      int c = a + b;
      a = b;
      b = c;
    }
    synchronized (this) {
      sum += b;
    }
  }

  public synchronized int getSum() {
    return sum;
  }

  public static class RunnableImpl implements Runnable {
    private ThreadSafeFibonacciAdder adder;

    public RunnableImpl(ThreadSafeFibonacciAdder adder) {
      this.adder = adder;
    }

    public void run() {
      for (int i = 0; i < 10_000_000; ++i) {
        adder.add(i % 50);
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    System.setOut(new PrintStream(new OutputStream() {
      @Override public void write(int b) throws IOException {}
    }));
    long start = System.nanoTime();
    List<Thread> threads = new ArrayList<>();
    ThreadSafeFibonacciAdder adder = new ThreadSafeFibonacciAdder();
    for (int i = 0; i < 4; ++i) {
      Thread t = new Thread(new RunnableImpl(adder));
      t.start();
      threads.add(t);
    }
    for (Thread t : threads) {
      t.join();
    }
    System.err.println(adder.getSum());
    System.err.println("Execution time: " + (System.nanoTime() - start) / 1e9);
  }
}
