package java_implementation.linked_list.mergesort_top_down;
import java.util.Arrays;
import java.util.LinkedList;
import java_implementation.tools.tools;

public class mergesort_top_down
{
  public LinkedList<Integer> sort(LinkedList<Integer> array)
  {
    if (array.size() == 1)
    {
      return array;
    }

    int middle = array.size() / 2;

    LinkedList<Integer> a = sort(tools.sublist(array, 0, middle));
    LinkedList<Integer> b = sort(tools.sublist(array, middle, array.size()));
    LinkedList<Integer> ab = merge(a, b);
    return ab;
  }

  public LinkedList<Integer> merge(LinkedList<Integer> a, LinkedList<Integer> b)
  {
    LinkedList<Integer> result = new LinkedList<Integer>();
    LinkedList<Integer> c = new LinkedList<Integer>();

    while (a.size() != 0 && b.size() != 0)
    {
        if (a.get(0) < b.get(0))
        {
          result.add(new Integer(a.get(0)));
          a.remove(0);
        }
        else
        {
          result.add(new Integer(b.get(0)));
          b.remove(0);
        }

        if (a.size() == 0)
        {
          c = b;
        }
        else if (b.size() == 0)
        {
          c = a;
        }
    }

    int index = 0;
    while (index < c.size())
    {
      result.add(c.get(index));
      index++;
    }
    //System.out.println(result);
    return result;
  }
}
