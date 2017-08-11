package java_implementation.linked_list.quicksort_lomuto;
import java.util.LinkedList;
import java.util.Arrays;

// initial call array, 0, array.size() - 1 

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
    //System.out.println("Start" + Arrays.toString(array.toArray()));
    if (begin < end)
    {
      int pivot = partition(array, begin, end);
      sort(array, begin, pivot - 1); // -1
      sort(array, pivot + 1, end); // + 1
    }
    return array;
  }

  public int partition (LinkedList<Integer> array, int begin, int end)
  {
    int pivot = array.get(end);

    int j = begin - 1;
    for (int i = begin; i < end; i++) // end - 1 will not work
    {
      //System.out.println(Arrays.toString(array.toArray()));
      if (array.get(i) < pivot) // <=
      {
        j++;

        // Swap i and j
        int element_i = array.get(i);
        int element_j = array.get(j);
        array.set(i, element_j);
        array.set(j, element_i);
      }
    }

    j++;
    if (pivot < array.get(j))
    {
      int temp = array.get(end);
      array.set(end, array.get(j));
      array.set(j, temp);
    }
    //System.out.println("begin " + begin + "\tend " + end + "\tpivot " + pivot + "\t" + Arrays.toString(array.toArray()));
    //System.out.println("return pivot " + j);

    return j;
  }
}
