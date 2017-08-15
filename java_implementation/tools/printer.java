package java_implementation.tools;

public class printer
{
  String loading[] = {"|", "/", "-", "\\"};
  String text = "";
  int index = 0;

  public printer(String text)
  {
    this.text = text;
  }

  public void loading(int list_length)
  {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println(text + " tests in progess " + list_length + " [" +
      loading[index] + loading[index] + loading[index] + loading[index] + "]");
    index++;
    if (index > loading.length - 1)
      index = 0;
  }
}
