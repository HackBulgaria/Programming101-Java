package io.github.ivanvergiliev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJava7 {

  public static void main(String[] args) {
    List<String> input = Arrays.asList("eighteen", "three", "two", "four", "million", "1 billion");
    String result = input.stream()
        .filter(s -> s.contains("o"))
        .sorted((a, b) -> Integer.compare(a.length(), b.length()))
        .collect(Collectors.joining("; "));
    System.out.println(result);
  }

}
