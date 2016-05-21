package io.github.ivanvergiliev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ParallelSumThreads {
  private static final int BATCH_SIZE = 100_000;

  public static class PartialSumComputer implements Runnable {
    private List<Long> numbers;
    private int from;
    private int to;

    private LongAdder result;

    public PartialSumComputer(List<Long> numbers, int from, int to, LongAdder result) {
      this.numbers = numbers;
      this.from = from;
      this.to = to;
      this.result = result;
    }

    public void run() {
      for (int i = from; i < to; ++i) {
        result.add(numbers.get(i));
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    List<Long> numbers = LongStream.range(0, (long) 1e7).boxed().collect(Collectors.toList());
    List<Thread> threads = new ArrayList<>();
    LongAdder result = new LongAdder();
    for (int start = 0; start < numbers.size(); start += BATCH_SIZE) {
      int end = Math.min(start + BATCH_SIZE, numbers.size());
      Thread t = new Thread(new PartialSumComputer(numbers, start, end, result));
      t.start();
      threads.add(t);
    }
    for (Thread t : threads) {
      t.join();
    }
    System.out.println(result.sum());
  }

}
