package java_implementation.linked_list.tester;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java_implementation.tools.tools;
import java_implementation.linked_list.quicksort_hoare.quicksort_hoare;
import java_implementation.linked_list.mergesort_top_down.mergesort_top_down;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class tester
{
  public static void main (String args[]) throws FileNotFoundException
  {
    String path = "java_implementation/linked_list/tester/";

    // Display status of tests
    String loading[] = {"|", "/", "-", "\\"};
    int loading_index = 0;

    // Store data
    PrintWriter wdata = new PrintWriter(path + "tester_data_mergesort.txt");

    mergesort_top_down msort = new mergesort_top_down();
    quicksort_hoare qsort = new quicksort_hoare();

    //int tests = 1000000;
    int tests = 1000;
    int list_length = 2;

    long total_nano_mergesort = 0L;

    System.out.println("Starting mergesort tests...");
    for (int i = 0; i < tests; i++)
    {
      // Clear screen and print mergesort tests
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Mergesort tests in progess " + loading[loading_index] + loading[loading_index] + loading[loading_index] + list_length);
      loading_index++;
      if (loading_index > loading.length - 1)
        loading_index = 0;

      // Generate array to be sorted
      Integer int_data[] = tools.generateInt(list_length);
      LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));

      // Measure time it takes mergesort to sort array
      long startTime = System.nanoTime();
      LinkedList<Integer> test = msort.sort(data);
      long endTime = System.nanoTime();
      total_nano_mergesort += (endTime - startTime);

      // Store data
      wdata.println(endTime - startTime );

      // Check that mergesort is working correctly
      if (tools.sorted(test) == false)
      {
        System.out.println("Sorting failed . . . . .");
        System.exit(0);
        break;
      }

      // Slowly increase the size of the array
      list_length += 1;
    }

    long total_nano_quicksort = 0L;

    // Store data for quicksort
    wdata.close();
    wdata = new PrintWriter(path + "tester_data_quicksort.txt");

    list_length = 2;
    System.out.println("Starting quicksort tests...");
    for (int i = 0; i < tests; i++)
    {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Quicksort tests in progess " + loading[loading_index] + loading[loading_index] + loading[loading_index] + list_length);
      loading_index++;
      if (loading_index > loading.length - 1)
        loading_index = 0;

      Integer int_data[] = tools.generateInt(list_length);
      LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));

      long startTime = System.nanoTime();
      LinkedList<Integer> test = qsort.sort(data, 0, data.size() - 1);
      long endTime = System.nanoTime();
      total_nano_quicksort += (endTime - startTime);

      wdata.println(endTime - startTime );

      if (tools.sorted(test) == false)
      {
        System.out.println("Sorting failed . . . . .");
        System.exit(0);
        break;
      }
      list_length++;
    }

    System.out.print("\033[H\033[2J");

    System.out.println("Mergesort");
    double nano_mergesort = (double) total_nano_mergesort / tests;
    System.out.println(total_nano_mergesort + " nsec - Total nanoseconds");
    System.out.println(nano_mergesort + " nsec - Average nanoseconds");

    System.out.println("Quicksort");
    double nano_quicksort = (double) total_nano_quicksort / tests;
    System.out.println(total_nano_quicksort + " nsec - Total nanoseconds");
    System.out.println(nano_quicksort + " nsec - Average nanoseconds\n\n");

    wdata.close();
  }
}
