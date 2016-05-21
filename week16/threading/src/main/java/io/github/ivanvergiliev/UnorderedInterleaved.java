package io.github.ivanvergiliev;

public class UnorderedInterleaved {

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

  public static void main(String[] args) {
    System.out.println("starting...");
    for (int i = 0; i < 10; ++i) {
      Thread t = new Thread(new RunnableImpl(i));
      t.start();
    }
    System.out.println("After all");

    // Thread execution is interleaved - preemptive multitasking.
  }

}
