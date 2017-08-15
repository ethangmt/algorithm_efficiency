package java_implementation.tester;

import java.io.FileNotFoundException;

public class tester
{
  public static void main (String args[]) throws FileNotFoundException
  {
    final int tests = 1000;

    java_implementation.array.tester.tester array = new java_implementation.array.tester.tester(tests);
    java_implementation.linked_list.tester.tester linked_list = new java_implementation.linked_list.tester.tester(tests);

    Thread array_quicksort = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          array.quicksort();
        }
        catch (FileNotFoundException exception)
        {
        }
      }
    });

    Thread array_mergesort = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          array.mergesort();
        }
        catch (FileNotFoundException exception)
        {
        }
      }
    });

    Thread linked_list_quicksort = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          linked_list.quicksort();
        }
        catch (FileNotFoundException exception)
        {
        }
      }
    });

    Thread linked_list_mergesort = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          linked_list.mergesort();
        }
        catch (FileNotFoundException exception)
        {
        }
      }
    });

    array_quicksort.start();
    array_mergesort.start();
    linked_list_quicksort.start();
    linked_list_mergesort.start();

    while (true)
    {
      if ((array_quicksort.getState() == Thread.State.TERMINATED && array_mergesort.getState() == Thread.State.TERMINATED) &&
      (linked_list_quicksort.getState() == Thread.State.TERMINATED && linked_list_mergesort.getState() == Thread.State.TERMINATED))
      {
        array.print_results();
        linked_list.print_results();
        break;
      }
    }
  }
}
