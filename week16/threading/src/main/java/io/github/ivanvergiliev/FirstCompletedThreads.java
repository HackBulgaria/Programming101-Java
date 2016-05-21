package io.github.ivanvergiliev;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class FirstCompletedThreads {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch resultComputed = new CountDownLatch(1);
    AtomicLong result = new AtomicLong();
    Thread t1 = new Thread(() -> {
      long localResult = LongStream.range(1, (long) 1e9).sum();
      result.compareAndSet(0, localResult);
      // What if local result can be 0?
      resultComputed.countDown();
    });
    Thread t2 = new Thread(() -> {
      long localResult = LongStream.range((long) 1e9, (long) 1.37e9)
          .reduce(1, (a, b) -> (a + b) % 1337);
      result.compareAndSet(0, localResult);
      resultComputed.countDown();
    });
    t1.start();
    t2.start();
    resultComputed.await();
    System.out.println(result);
  }

}
