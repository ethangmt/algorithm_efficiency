package java_implementation.array.tester;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java_implementation.array.mergesort_top_down.mergesort_top_down;
import java_implementation.array.quicksort_hoare.quicksort_hoare;
import java_implementation.tools.tools;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java_implementation.tools.printer;

public class tester
{
  static String path = "java_implementation/array/tester/";
  static int tests = 10000;
  static boolean mergesort = false;
  static boolean quicksort = false;
  static long total_nano_mergesort = 0L;
  static long total_nano_quicksort = 0L;
  static double nano_mergesort = 0;
  static double nano_quicksort = 0;

  public static void mergesort() throws FileNotFoundException
  {
    PrintWriter wdata = new PrintWriter(path + "tester_data_mergesort.txt");

    printer print = new printer("Mergesort");
    mergesort_top_down msort = new mergesort_top_down();

    int list_length = 2;

    for (int i = 0; i < tests; i++)
    {
      print.loading(i);

      int int_data[] = tools.generateint(list_length);

      long startTime = System.nanoTime();
      int test[] = msort.sort(int_data);
      long endTime = System.nanoTime();
      total_nano_mergesort += (endTime - startTime);

      wdata.println(endTime - startTime );

      if (tools.sorted(test) == false)
      {
        System.out.println("Sorting failed . . . . .");
        System.exit(1);
        break;
      }

      list_length++;
    }

    nano_mergesort = (double) total_nano_mergesort / tests;
    wdata.print("\n" + total_nano_mergesort + "\n" + nano_mergesort);
    wdata.close();
    System.out.print("\033[H\033[2J");

    mergesort = true;
  }

  public static void quicksort() throws FileNotFoundException
  {
    PrintWriter wdata = new PrintWriter(path + "tester_data_quicksort.txt");

    printer print = new printer("Quicksort");
    quicksort_hoare qsort = new quicksort_hoare();

    int list_length = 2;

    for (int i = 0; i < tests; i++)
    {
      print.loading(i);

      int int_data[] = tools.generateint(list_length);

      long startTime = System.nanoTime();
      int test[] = qsort.sort(int_data, 0, int_data.length - 1);
      long endTime = System.nanoTime();
      total_nano_quicksort += (endTime - startTime);

      wdata.println(endTime - startTime );

      if (tools.sorted(test) == false)
      {
        System.out.println("Sorting failed . . . . .");
        System.exit(1);
        break;
      }
      list_length++;
    }

    nano_quicksort = (double) total_nano_quicksort / tests;
    wdata.print("\n" + total_nano_quicksort + "\n" + nano_quicksort);
    wdata.close();
    System.out.print("\033[H\033[2J");

    quicksort = true;
  }

  public static void print_results()
  {
    if (mergesort && quicksort)
    {
      double nano_mergesort = (double) total_nano_mergesort / tests;
      System.out.println("Mergesort");
      System.out.println(total_nano_mergesort + " nsec - Total nanoseconds");
      System.out.println(nano_mergesort + " nsec - Average nanoseconds");

      double nano_quicksort = (double) total_nano_quicksort / tests;
      System.out.println("Quicksort");
      System.out.println(total_nano_quicksort + " nsec - Total nanoseconds");
      System.out.println(nano_quicksort + " nsec - Average nanoseconds\n\n");
    }
    else
    {
      System.out.println("Sorting tests have not finished");
    }
  }
}
