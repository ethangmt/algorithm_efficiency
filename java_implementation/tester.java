package java_implementation;

import java.io.FileNotFoundException;

public class tester
{
  public static void main (String args[]) throws FileNotFoundException
  {
    final int tests = 1000;

    java_implementation.array.tester.tester array = new java_implementation.array.tester.tester(tests);
    array.quicksort();
    array.mergesort();

    java_implementation.linked_list.tester.tester linked_list = new java_implementation.linked_list.tester.tester(tests);
    linked_list.quicksort();
    linked_list.mergesort();

    array.print_results();
    linked_list.print_results();
  }
}
