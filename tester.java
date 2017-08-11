import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java_implementation.tools.tools;
//import java_implementation.linked_list.quicksort_hoare.quicksort_hoare;
//import java_implementation.linked_list.mergesort_top_down.mergesort_top_down;
import java_implementation.array.mergesort_top_down.mergesort_top_down;
import java_implementation.array.quicksort_hoare.quicksort_hoare;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class tester extends Thread
{
  public static void main (String args[]) throws FileNotFoundException
  {
    // Display status of tests
    String loading[] = {"|", "/", "-", "\\"};
    int loading_index = 0;

    // Store data
    PrintWriter writer = new PrintWriter("tester_lists.txt");
    PrintWriter wdata = new PrintWriter("tester_data_mergesort.txt");

    mergesort_top_down msort = new mergesort_top_down();
    quicksort_hoare qsort = new quicksort_hoare();

    //int tests = 1000000;
    int tests = 100000;
    int list_length = 2;

    long total_nano = 0L;

    wdata.println("mergesort");
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
      int int_data[] = tools.generateint(list_length); //Integer
      //LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));

      // Measure time it takes mergesort to sort array
      long startTime = System.nanoTime();
      int test[] = msort.sort(int_data); //LinkedList
      long endTime = System.nanoTime();
      total_nano += (endTime - startTime);

      // Store data
      wdata.println(endTime - startTime );//+ "," + list_length);

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

    double nano = (double) total_nano / tests;
    System.out.println(total_nano + " nsec - Total nanoseconds");
    System.out.println(nano + " nsec - Average nanoseconds");

    wdata.println("\n");

    total_nano = 0L;

    // Store data for quicksort
    wdata.close();
    wdata = new PrintWriter("tester_data_quicksort.txt");

    list_length = 2;
    wdata.println("quicksort");
    System.out.println("Starting quicksort tests...");
    for (int i = 0; i < tests; i++)
    {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Quicksort tests in progess " + loading[loading_index] + loading[loading_index] + loading[loading_index] + list_length);
      loading_index++;
      if (loading_index > loading.length - 1)
        loading_index = 0;

      int int_data[] = tools.generateint(list_length); //Integer
      //LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));

      long startTime = System.nanoTime();
      int test[] = qsort.sort(int_data, 0, int_data.length - 1); //linkledlist data.size
      long endTime = System.nanoTime();
      total_nano += (endTime - startTime);

      wdata.println(endTime - startTime );//+ "," + list_length);

      if (tools.sorted(test) == false)
      {
        System.out.println("Sorting failed . . . . .");
        System.exit(0);
        break;
      }
      list_length++;
    }

    nano = (double) total_nano / tests;
    System.out.println(total_nano + " nsec - Total nanoseconds");
    System.out.println(nano + " nsec - Average nanoseconds\n\n");

    writer.close();
    wdata.close();
  }
}
