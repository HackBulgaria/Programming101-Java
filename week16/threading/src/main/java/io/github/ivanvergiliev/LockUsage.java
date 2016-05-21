package io.github.ivanvergiliev;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUsage {

  static Lock l = new ReentrantLock();

  public static void main(String[] args) {
    l.lock();
    try {
      // Do something exclusive.
    } finally {
      l.unlock();
    }
  }

}
