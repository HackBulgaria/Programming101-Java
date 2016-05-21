package io.github.ivanvergiliev;

public class UnorderedJoinImmediately {

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
    for (int i = 0; i < 10; ++i) {
      Thread t = new Thread(new RunnableImpl(i));
      t.start();
      t.join();
    }
    System.out.println("After all");
    // Joining each thread immediately after it's started eliminates parallelism.
  }

}
