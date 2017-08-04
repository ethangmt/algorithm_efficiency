import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java_implementation.linked_list.quicksort_lomuto.quicksort_lomuto;
import java_implementation.linked_list.mergesort_top_down.mergesort_top_down;

public class tester
{
  public static void main (String args[])
  {
    mergesort_top_down msort = new mergesort_top_down();
    quicksort_lomuto qsort = new quicksort_lomuto();

    int tests = 50;
    long total = 0L;

    System.out.println("Starting mergesort tests...");
    for (int i = 0; i < tests; i++)
    {
        Integer int_data[] = generateInt(10);
        LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));

        long startTime = System.nanoTime();
        LinkedList<Integer> test = msort.sort(data);
        long endTime = System.nanoTime();
        total += (endTime - startTime);

        System.out.println(test + " Sorted: " + sorted(test));
    }
    double seconds = (double) (total / tests) / 1000000000;
    System.out.println("Average: " + seconds + " seconds");

    System.out.println("\n\n");

    /**System.out.println("Starting quicksort tests...");
    for (int i = 0; i < tests; i++)
    {
      Integer int_data[] = generateInt(10);
      LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));
      LinkedList<Integer> test = qsort.sort(data, 1, data.size() - 1); //0
      System.out.println(test + " Sorted: " + sorted(test));
    }**/
  }

  public static Integer[] generateInt (int length)
  {
    Integer result[] = new Integer[length];
    Random data_generation = new Random();

    for (int i = 0; i < length; i++)
    {
        result[i] = data_generation.nextInt(100);
    }

    return result;
  }

  public static boolean sorted (LinkedList<Integer> data)
  {
    int previous = -1;
    for (int i = 0; i < data.size(); i++)
    {
      if (previous == -1)
      {
        previous = data.get(i);
      }
      else if (previous > data.get(i))
      {
        return false;
      }
    }
    return true;
  }
}
