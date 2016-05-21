package io.github.ivanvergiliev;

import java.util.ArrayList;
import java.util.List;

public class UnorderedJoinAll {

  public static class RunnableImpl implements Runnable {
    private int id;

    public RunnableImpl(int id) {
      this.id = id;
    }

    public void run() {
      for (int i = 0; i < 10; ++i) {
        System.out.println("Thread " + id + ", line " + i);
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("starting...");
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 10; ++i) {
      Thread t = new Thread(new RunnableImpl(i));
      t.start();
      threads.add(t);
    }
    for (Thread t : threads) {
      t.join();
    }
    System.out.println("After all");
    // Joining each thread immediately after it's started eliminates parallelism.
    // => Need to start each thread asynchronously, then join each of them.
  }

}
