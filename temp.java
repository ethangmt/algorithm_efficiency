import java_implementation.array.mergesort_top_down.mergesort_top_down;
import java_implementation.array.quicksort_hoare.quicksort_hoare;
import java_implementation.tools.tools;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Random;

public class temp
{
  public static void main (String args[])
  {
      mergesort_top_down qsort = new mergesort_top_down();
      int tests = 100;
      int length = 8;

      System.out.println("Starting mergesort tests...");
      for (int i = 0; i < tests; i++)
      {
        int int_data[] = tools.generateint(length);
        //LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));

        //LinkedList<Integer> test = qsort.sort(data, 0, data.size() - 1);
        int[] test = qsort.sort(int_data);//, 0, int_data.length - 1);
        System.out.println(Arrays.toString(test) + " Sorted: " + tools.sorted(test));
      }
  }
}
