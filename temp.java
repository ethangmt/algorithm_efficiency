import java_implementation.linked_list.quicksort_lomuto.quicksort_lomuto;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Random;

public class temp
{
  public static void main (String args[])
  {
      quicksort_lomuto qsort = new quicksort_lomuto();
      int tests = 100;
      int length = 15;

      System.out.println("Starting quicksort tests...");
      for (int i = 0; i < tests; i++)
      {
        Integer int_data[] = generateInt(length);
        LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));
        LinkedList<Integer> test = qsort.sort(data, 0, data.size() - 1); //0
        System.out.println(test + " Sorted: " + sorted(test));
      }
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
