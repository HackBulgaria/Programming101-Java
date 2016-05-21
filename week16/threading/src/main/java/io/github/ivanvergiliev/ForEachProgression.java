package io.github.ivanvergiliev;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachProgression {

  public static void main(String[] args) {
    List<String> l = Arrays.asList("one", "two", "four", "eight");

    for (int i = 0; i < l.size(); ++i) {
      System.out.println(l.get(i));
    }

    for (String s : l) {
      System.out.println(s);
    }

    l.forEach(new Consumer<String>() {
      public void accept(String s) {
        System.out.println(s);
      }
    });

    // lambda expression
    l.forEach(s -> System.out.println(s));

    // method reference - "use the method println(String) on the System.out object
    // and apply it to each element of this list."
    l.forEach(System.out::println);
  }

}
