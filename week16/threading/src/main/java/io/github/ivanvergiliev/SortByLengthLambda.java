package io.github.ivanvergiliev;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByLengthLambda {

  public static void main(String[] args) {
    List<String> l = Arrays.asList("eighteen", "three", "two", "four", "million", "1 billion");
    Collections.sort(l, (a, b) -> Integer.compare(a.length(), b.length()));
    l.forEach(System.out::println);
  }

}
