package java_implementation.tools;
import java.util.LinkedList;

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
}
