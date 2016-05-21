package io.github.ivanvergiliev;

public class NonVolatileFlag {
  private static boolean flag = false;

  public static class FlagChecker implements Runnable {
    public void run() {
      @SuppressWarnings("unused")
      long iter = 0; // Used for debugging in order to determine the number of iterations so far.
      while (flag == false) {
        ++iter;
        // Wait and do nothing.
      }
    }
  }

  public static class FlagSetter implements Runnable {
    public void run() {
      int count = 0;
      while (true) {
        ++count;
        if (count > 100_000) {
          break;
        }
      }
      flag = true;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; ; ++i) {
      System.out.println("Running iteration " + i);
      flag = false;
      Thread checker = new Thread(new FlagChecker());
      Thread setter = new Thread(new FlagSetter());
      checker.start();
      setter.start();
      checker.join();
    }
  }

}
