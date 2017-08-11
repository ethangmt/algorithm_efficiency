package java_implementation.tools;
import java.util.LinkedList;
import java.util.Random;

public class tools
{
  public static LinkedList<Integer> sublist (LinkedList<Integer> array, int begin, int end)
  {
    LinkedList<Integer> result = new LinkedList<Integer>();
    while (begin < end)
    {
      result.add(array.get(begin));
      begin ++;
    }
    return result;
  }

  public static Integer[] generateInt (int length) // delete method if array.aslist works with int[] TODO
  {
    Integer result[] = new Integer[length];
    Random data_generation = new Random(123);

    for (int i = 0; i < length; i++)
    {
        result[i] = data_generation.nextInt(100);
    }

    return result;
  }

  public static int[] generateint (int length)
  {
    int result[] = new int[length];
    Random data_generation = new Random(123);

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
      else
      {
        if (i + 1 < data.size())
          if (previous > data.get(i) || data.get(i + 1) < data.get(i))
            return false;
        else if (previous > data.get(i))
          return false;
      }
    }
    return true;
  }

  public static boolean sorted (int[] data)
  {
    int previous = -1;
    for (int i = 0; i < data.length; i++)
    {
      if (previous == -1)
      {
        previous = data[i];
      }
      else
      {
        if (i + 1 < data.length)
          if (previous > data[i] || data[i + 1] < data[i])
            return false;
        else if (previous > data[i])
          return false;
      }
    }
    return true;
  }
}
