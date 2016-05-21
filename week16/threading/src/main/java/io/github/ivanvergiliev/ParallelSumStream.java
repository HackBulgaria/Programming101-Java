package io.github.ivanvergiliev;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ParallelSumStream {
  public static void main(String[] args) throws InterruptedException {
    List<Long> numbers = LongStream.range(0, (long) 1e7).boxed().collect(Collectors.toList());
    long result = numbers.parallelStream().reduce(0L, (x, y) -> x + y);
    System.out.println(result);
  }
}
