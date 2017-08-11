package java_implementation.array.mergesort_top_down;

public class mergesort_top_down
{
  public int[] sort(int[] array)
  {
    if (array.length == 1)
    {
      return array;
    }

    int middle = array.length / 2;

    int acopy[] = new int[middle];
    System.arraycopy(array, 0, acopy, 0, acopy.length);
    int a[] = sort(acopy);

    int bcopy[] = new int[array.length - middle]; // -1
    System.arraycopy(array, middle, bcopy, 0, bcopy.length);
    int b[] = sort(bcopy);

    int ab[] = merge(a, b);
    return ab;
  }

  public int[] merge(int a[], int b[])
  {
    int result[] = new int[a.length + b.length];
    int index = 0;
    int i = 0, j = 0;

    while (i != a.length && j != b.length)
    {
      if (a[i] < b[j])
      {
        result[index] = a[i];
        index++;
        i++;
      }
      else
      {
        result[index] = b[j];
        index++;
        j++;
      }
    }

    if (i == a.length)
    {
      while (j < b.length)
      {
        result[index] = b[j];
        index++;
        j++;
      }
    }
    else if (j == b.length)
    {
      while (i < a.length)
      {
        result[index] = a[i];
        index++;
        i++;
      }
    }

    return result;
  }
}
