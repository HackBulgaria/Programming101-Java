package io.github.ivanvergiliev;

import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

public class FirstCompletedFutures {

  public static void main(String[] args) {
    CompletableFuture<Long> f1 = CompletableFuture
        .supplyAsync(() -> {
      return LongStream
          .range(1, (long) 1e9).sum();
    });
    CompletableFuture<Long> f2 = CompletableFuture
        .supplyAsync(() -> {
      return LongStream
          .range((long) 1e9, (long) 1.37e9)
          .reduce(1, (a, b) -> (a + b) % 1337);
    });
    f1.acceptEitherAsync(f2, System.out::println)
        .join();
  }

}
