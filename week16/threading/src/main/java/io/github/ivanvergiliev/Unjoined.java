package io.github.ivanvergiliev;

public class Unjoined {

  public static class RunnableImpl implements Runnable {
    public void run() {
      for (int i = 0; i < 100; ++i) {
        System.out.println("line " + i);
      }
    }
  }

  public static void main(String[] args) {
    Thread t = new Thread(new RunnableImpl());
    t.start();
    System.out.println("started thread");
    // Start is asynchronous.
  }

}
