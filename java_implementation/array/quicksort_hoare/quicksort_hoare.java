package java_implementation.array.quicksort_hoare;

// initial call array, 0, array.size() - 1

public class quicksort_hoare
{
  public int[] sort(int[] array, int begin, int end)
  {
    if (begin < end)
    {
      int pivot = partition(array, begin, end);
      sort(array, begin, pivot); //pivot - 1
      sort(array, pivot + 1, end);
    }
    return array;
  }

  public int partition(int array[], int begin, int end)
  {
      int pivot = array[begin];
      int i = begin - 1;
      int j = end + 1; // end + 1

      while (true)
      {
        do
        {
          i++;
        }
        while (array[i] < pivot);

        do
        {
          j--;
        }
        while (array[j] > pivot);


        if (i >= j)
        {
          return j;
        }

        int i_element = array[i];
        int j_element = array[j];
        array[i] = j_element;
        array[j] = i_element;
      }
  }
}
