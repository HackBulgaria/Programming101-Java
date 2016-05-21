package io.github.ivanvergiliev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ParallelSumFutures {
  private static final int BATCH_SIZE = 100_000;

  public static void main(String[] args) throws InterruptedException {
    List<Long> numbers = LongStream.range(0, (long) 1e7).boxed().collect(Collectors.toList());
    List<CompletableFuture<Long>> futures = new ArrayList<>();
    for (int start = 0; start < numbers.size(); start += BATCH_SIZE) {
      int from = start;
      int to = Math.min(start + BATCH_SIZE, numbers.size());
      CompletableFuture<Long> f = CompletableFuture.supplyAsync(() -> {
        return numbers.subList(from, to).stream().reduce(0L, (x, y) -> x + y);
      });
      futures.add(f);
    }
    long result = futures.stream()
        .map(future -> future.join())
        .reduce(0L, (x, y) -> x + y);
    System.out.println(result);
  }

}
