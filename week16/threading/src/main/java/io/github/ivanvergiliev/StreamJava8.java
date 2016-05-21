package io.github.ivanvergiliev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamJava8 {

  public static void main(String[] args) {
    List<String> input = Arrays.asList("eighteen", "three", "two", "four", "million", "1 billion");
    List<String> filtered = new ArrayList<>();
    for (String s : input) {
      if (s.contains("o")) {
        filtered.add(s);
      }
    }
    Collections.sort(filtered, (a, b) -> Integer.compare(a.length(), b.length()));

    String result = "";
    boolean shouldAddSemicolon = false;
    for (String s : filtered) {
      if (shouldAddSemicolon) {
        result += "; ";
      }
      shouldAddSemicolon = true;
      result += s;
    }
    System.out.println(result);
  }

}
