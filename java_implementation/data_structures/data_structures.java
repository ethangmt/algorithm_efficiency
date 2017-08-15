package java_implementation.data_structures;

import java.util.LinkedList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class data_structures
{
  public static void main (String args[]) throws FileNotFoundException
  {
    String path = "java_implementation/data_structures/";
    int tests = 1000;
    PrintWriter wdata;

    //Test arrays
    int array[] = {1};

    long array_read_total = 0L;
    long array_write_total = 0L;
    double array_read_average = 0;
    double array_write_average = 0;

    wdata = new PrintWriter(path + "array_read.txt");
    for (int i = 0; i < tests; i++)
    {
      long start_time = System.nanoTime();
      int temp = array[0];
      long stop_time = System.nanoTime();

      array_read_total += (stop_time - start_time);
      wdata.println(stop_time - start_time);
    }

    array_read_average = (double) array_read_total / tests;

    wdata.println(array_read_total + "\n" + array_read_average);
    wdata.close();

    wdata = new PrintWriter(path + "array_write.txt");
    for (int i = 0; i < tests; i++)
    {
      long start_time = System.nanoTime();
      array[0] = 10;
      long stop_time = System.nanoTime();

      array_write_total += (stop_time - start_time);
      wdata.println(stop_time - start_time);
    }

    array_write_average = (double) array_write_total / tests;

    wdata.println(array_write_total + "\n" + array_write_average);
    wdata.close();

    //Test linked list
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(10);

    long list_read_total = 0L;
    long list_write_total = 0L;
    double list_read_average = 0;
    double list_write_average = 0;

    wdata = new PrintWriter(path + "linked_list_read.txt");
    for (int i = 0; i < tests; i++)
    {
      long start_time = System.nanoTime();
      int temp = list.get(0);
      long stop_time = System.nanoTime();

      list_read_total += (stop_time - start_time);
      wdata.println(stop_time - start_time);
    }

    list_read_average = (double) list_read_total / tests;

    wdata.println(list_read_total + "\n" + list_read_average);
    wdata.close();

    wdata = new PrintWriter(path + "linked_list_write.txt");
    for (int i = 0; i < tests; i++)
    {
      long start_time = System.nanoTime();
      list.set(0, 10);
      long stop_time = System.nanoTime();

      list_write_total += (stop_time - start_time);
      wdata.println(stop_time - start_time);
    }

    list_write_average = (double) list_write_total / tests;

    wdata.println(list_write_total + "\n" + list_write_average);
    wdata.close();
  }
}
