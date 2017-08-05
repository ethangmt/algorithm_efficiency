package java_implementation.quicksort_hoare;

public class quicksort_hoare
{
  public LinkedList<Integer> sort(LinkedList<Integer> array, int begin, int end)
  {
    if (begin < end)
    {
      int pivot = partition(array, begin, end);
      sort(array, begin, pivot - 1);
      sort(array, pivot + 1, end);
    }
    return array;
  }

  public int partition ()
  {

  }
}
