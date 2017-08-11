package java_implementation.linked_list.quicksort_hoare;
import java.util.LinkedList;

// array 0, size - 1
public class quicksort_hoare
{
  public LinkedList<Integer> sort(LinkedList<Integer> array, int begin, int end)
  {
    if (begin < end)
    {
      int pivot = partition(array, begin, end);
      sort(array, begin, pivot);
      sort(array, pivot + 1, end);
    }
    return array;
  }

  public int partition(LinkedList<Integer> array, int begin, int end)
  {
      int pivot = array.get(begin);
      int i = begin - 1;
      int j = end + 1;

      while (true)
      {
        do
        {
          i++;
        }
        while (array.get(i) < pivot);

        do
        {
          j--;
        }
        while (array.get(j) > pivot);


        if (i >= j)
        {
          return j;
        }

        int i_element = array.get(i);
        int j_element = array.get(j);
        array.set(i, j_element);
        array.set(j, i_element);
      }
  }
}
