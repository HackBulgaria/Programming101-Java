package io.github.ivanvergiliev;

public class Unjoined1 {

  public static class RunnableImpl implements Runnable {
    public void run() {
      for (int i = 0; i < 100; ++i) {
        System.out.println("line " + i);
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new RunnableImpl());
    t.start();
    t.join();
    System.out.println("after thread");
    // Start is asynchronous. => Need to use Thread.join() to wait for a thread to finish.
  }

}
