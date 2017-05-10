import java.util.*;


public class tidy_numbers
{
  
  public String nextTidy(String x)
  {
    if(x.length() == 1)
      return x;
    
    int[] a = new int[x.length()];
    for(int i = 0; i < x.length(); i++)
    {
      int y = 0;
      if(i == x.length()-1)
      {
        y = Integer.parseInt(x.substring(i));
      }
      else
        y = Integer.parseInt(x.substring(i,i+1));
      a[i] = y;
    }
    int i = 0;
    int equals = 0;
    int min = a[0];
    while(i<a.length-1)
    {
      if(a[i] > min)
      {
        equals = 0;
      }
      if(a[i] > a[i+1])
      {
        min = i - equals;
        a[min] = a[min]-1;
        for(int j = min+1; j< a.length; j++)
          a[j] = 9;
      }
      
      if(a[i] == a[i+1])
        equals ++;
      min = a[i];     
      i++;
    }
    
    String r = "";
    if(a[0] == 0)
      for(int j = 1; j<a.length; j++)
    {
      r += a[j];
    }
    else      
      for(int j = 0; j<a.length; j++)
    {
      r += a[j];
    }
    
    return r;
  }
  
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    tidy_numbers tidy = new tidy_numbers();
                                          
    int x = in.nextInt();
    for(int i = 0; i< x; i++)
    {
      String y = tidy.nextTidy(in.next());
      int j = i+1;
      System.out.println("Case #" + j + ": " + y);
    }
    
  }
}