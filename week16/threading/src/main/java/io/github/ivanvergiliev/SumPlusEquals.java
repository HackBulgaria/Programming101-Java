package io.github.ivanvergiliev;

import java.util.ArrayList;
import java.util.List;

public class SumPlusEquals {
  private static int sum = 0;

  public static class RunnableImpl implements Runnable {
    public void run() {
      for (int i = 0; i < 1000; ++i) {
        sum += 1;
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 100; ++i) {
      Thread t = new Thread(new RunnableImpl());
      t.start();
      threads.add(t);
    }
    for (Thread t : threads) {
      t.join();
    }
    System.out.println(sum);
  }

}
