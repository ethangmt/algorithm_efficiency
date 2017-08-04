package java_implementation.linked_list.quicksort_lomuto;
import java.util.LinkedList;
import java.util.Arrays;
/**
 *
 * Quicksort algorithm
 *
 * 1.Pick pivot
 * 2.Partition array
 * 3.Recursively apply 1 and 2 to subarrays
 */

public class quicksort_lomuto
{
  public LinkedList<Integer> sort(LinkedList<Integer> array, int begin, int end)
  {
    if (begin < end)
    {
      int pivot = partition(array, begin, end);
      //System.out.println(begin + "\t" + end + "\t" + pivot + "\t" + Arrays.toString(array.toArray()));
      sort(array, begin, pivot - 1);
      sort(array, pivot + 1, end);
    }
    return array;
  }

  public int partition (LinkedList<Integer> array, int begin, int end)
  {
    int pivot = array.get(end);
    int j = begin - 1;
    for (int i = begin; i < end - 1; i++)
    {
      if (array.get(i) < pivot) // <=
      {
        j++;
        // Swap i and j
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
      }
    }

    if (pivot < array.get(j + 1))
    {
      int temp = array.get(end);
      array.set(end, array.get(j + 1));
      array.set(j + 1, temp);
    }

    return j + 1;
  }
}
