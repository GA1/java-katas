package katas.kata1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Kata1 {
  /**
   * Run the exercises to ensure we got the right answers
   */
  public void runExercises() {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
  }

  /**
   * All exercises should be completed using Lambda expressions and the new
   * methods added to JDK 8 where appropriate. There is no need to use an
   * explicit loop in any of the code. Use method references rather than full
   * lambda expressions wherever possible.
   */
  /**
   * Exercise 1
   *
   * Create a string that consists of the first letter of each word in the list
   * of Strings provided.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
    System.out.println(list.stream().map((String s) -> s.charAt(0)).collect(
            StringBuilder::new,
            StringBuilder::append,
            StringBuilder::append).toString());
  }

  /**
   * Exercise 2
   *
   * Remove the words that have odd lengths from the list.
   */
  private void exercise2() {
    List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
    System.out.println(list.stream().filter(s -> s.length() % 2 == 0).collect(Collectors.joining(", ")));
  }

  /**
   * Exercise 3
   *
   * Replace every word in the list with its upper case equivalent.
   */
  private void exercise3() {
    List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
    System.out.println(list.stream().map(s -> s.toUpperCase()).collect(Collectors.joining(", ")));
  }

  /**
   * Exercise 4
   *
   * Convert every key-value pair of the map into a string and append them all
   * into a single string, in iteration order.
   */
  private void exercise4() {
    Map<String, Integer> map = new TreeMap<>();
    map.put("c", 3);
    map.put("b", 2);
    map.put("a", 1);
    System.out.println(map.entrySet().stream().map(p -> "(" + p.getKey() + ", " + p.getValue() + ")").collect(Collectors.joining(", ")));
  }

  /**
   * Exercise 5
   *
   * Create a new thread that prints the numbers from the list.
   */
  private void exercise5() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Runnable r = () -> System.out.println(list.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
    new Thread(r).start();
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Kata1 lesson = new Kata1();
    lesson.runExercises();
  }
}
