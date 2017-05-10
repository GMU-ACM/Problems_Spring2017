import java.util.*;
public class addTo100
{
  
  public Boolean adding(ArrayList<Integer> x, int y, String r)
  {
    if(x.size() == 0 && y == 100)
    {
      System.out.println(r);
      return true;
    }
    if(x.size() == 0)
      return false;
    int z = x.get(0);
    y = y+z;
    r+= "+"+z;
    x.remove(0);
    if(adding(x,y,r))
      return true;
    else
    {
      String s = ""+z;
      r = r.substring(0,r.length()-1-s.length());
      r += "-"+z;
      y = y-z-z;
    }
    if(adding(x,y,r))  
      return true;
    return false;
  }
  
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<Integer>();
    int x = in.nextInt();
    addTo100 b = new addTo100();
    for(int i = 0; i<x; i++)
    {
      int j = in.nextInt();
      list.add(j);
    }
    if(!b.adding(list,0,""))
      System.out.println("not possible");
  }
}