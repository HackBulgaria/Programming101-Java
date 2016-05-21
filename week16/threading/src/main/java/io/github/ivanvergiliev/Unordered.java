package io.github.ivanvergiliev;

public class Unordered {

  public static class RunnableImpl implements Runnable {
    private int id;

    public RunnableImpl(int id) {
      this.id = id;
    }

    public void run() {
      System.out.println("Executing runnable with id " + id);
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 11; ++i) {
      Thread t = new Thread(new RunnableImpl(i));
      t.start();
    }

    // Threads don't run in the order you've started them.
  }

}
