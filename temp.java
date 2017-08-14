import java_implementation.tools.tools;
//import java_implementation.linked_list.tester.tester;
import java_implementation.array.tester.tester;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Random;
import java.io.FileNotFoundException;
import java_implementation.linked_list.mergesort_top_down.mergesort_top_down;

public class temp
{
  public static void main (String args[]) throws FileNotFoundException
  {
    /**
      mergesort_top_down qsort = new mergesort_top_down();
      int tests = 100;
      int length = 8;

      System.out.println("Starting mergesort tests...");
      for (int i = 0; i < tests; i++)
      {
        Integer int_data[] = tools.generateInt(length);
        LinkedList<Integer> data = new LinkedList<Integer>(Arrays.asList(int_data));

        //LinkedList<Integer> test = qsort.sort(data, 0, data.size() - 1);
        LinkedList<Integer> test = qsort.sort(data);//, 0, int_data.length - 1);
        System.out.println(test + " Sorted: " + tools.sorted(test));
      }*/

      /**Thread t = new Thread(new Runnable(){
        @Override
        public void run() {
          try
          {
            tester.quicksort();
          }
          catch (FileNotFoundException exception)
          {
            System.out.println("Failed quicksort");
          }
        }
      });
      t.start();*/

      tester.quicksort();
      tester.mergesort();
      tester.print_results();
  }
}
