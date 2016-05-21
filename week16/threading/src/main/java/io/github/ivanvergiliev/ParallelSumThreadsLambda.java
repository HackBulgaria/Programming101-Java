package io.github.ivanvergiliev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ParallelSumThreadsLambda {
  private static final int BATCH_SIZE = 100_000;

  public static void main(String[] args) throws InterruptedException {
    List<Long> numbers = LongStream.range(0, (long) 1e7).boxed().collect(Collectors.toList());
    List<Thread> threads = new ArrayList<>();
    LongAdder result = new LongAdder();
    for (int start = 0; start < numbers.size(); start += BATCH_SIZE) {
      int from = start;
      int to = Math.min(start + BATCH_SIZE, numbers.size());
      Thread t = new Thread(() -> {
        for (int i = from; i < to; ++i) {
          result.add(numbers.get(i));
        }
      });
      t.start();
      threads.add(t);
    }
    for (Thread t : threads) {
      t.join();
    }
    System.out.println(result.sum());
  }

}
