import java.util.*;
public class checkTheCheck
{
  char[][] board = new char[8][8];
  public boolean whiteCheck()
  {
    for(int i = 0; i<8; i++)
    {
      for(int j = 0; j<8; j++)
    {
      switch(board[i][j]){
        case '.': break;
        case 'R': if(Rook(i,j,0)){
          
          System.out.println("rook"+i+""+j);
          return true;
        }
        else
          break;
          case 'P': if(pawn(i,j,0)){
          
          System.out.println("pawn"+i+""+j);
          return true;
        }
        else
          break;
        case 'B': if(bishop(i,j,0)){
          
          System.out.println("biship");
          return true;
        }
        else
          break;
        case 'Q': if(queen(i,j,0)){
          
          System.out.println("queen");
          return true;
        }
        else
          break;
        default: break;
      }
      
    }    
    }
    return false;
    
  }
  
  public boolean blackCheck()
  {
     for(int i = 0; i<8; i++)
        {
      for(int j = 0; j<8; j++)
    {
      switch(board[i][j]){
        case '.': break;
        case 'r': if(Rook(i,j,1))
          return true;
        else
          break;
        case 'p': if(pawn(i,j,1))
          return true;
        else
          break;
        case 'b': if(bishop(i,j,1))
          return true;
        else
          break;
        case 'q': if(queen(i,j,1))
          return true;
        else
          break;
        default: break;
      }
      
    }    
    }
    return false;
  }
  //rock
  public boolean Rook(int x, int y, int z)
  {
    int x1 = x;
    int y1 = y;
    board[x][y] = '.';
    while(x<8)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else x=9;
      }
      x++;
    }
    x=x1;
    while(x>=0)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else x=-1;
      }
      x--;
    }  
    x=x1;
    while(y<8)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else y=9;
      }
      y++;
    }
    y=y1;
    while(y>=0)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else y=-1;
      }
      y--;
    }
    y=y1;
        if(z==0)
      board[x1][y1] = 'B';
    else
      board[x1][y1] = 'b';
    
    return false;
  }
  ////////////////////////////////////////////////
  public boolean pawn(int x, int y, int z)
  {
    if(z==0)
    {
      if(x-1 <0)
        return false;
      else
        for(int i = 0; i<3; i++)
      {
        if(y-1+i >=8 || y-1+i <0)
        {}
        else
          if(board[x-1][y-1+i] == 'k')
        return true;
      }
    }
    
    if(z==1)
    {
      if(x+1 >=8)
        return false;
      else
        for(int i = 0; i<3; i++)
      {
        if(y+i-1 >=8 || y-1+i <0)
        {}
        else
          if(board[x+1][y-1+1] == 'K')
        return true;
      }
    }
    return false;
  }
  //////////////////////////////// 
  public boolean queen(int x, int y, int z)
  {
    
    int x1 = x;
    int y1 = y;
    board[x][y] = '.';
    while(x < 8 && y <8)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x++;
      y++;
    }
    x = x1;
    y = y1;
    while(x < 8 && y >=0)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x++;
      y--;
    }
    x = x1;
    y = y1;
    while(x >= 0 && y >=0)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x--;
      y--;
    }
    x = x1;
    y = y1;
    while(x >= 0 && y <8)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x--;
      y++;
    }
    x = x1;
    y = y1;
    while(x<8)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else break;
      }
      x++;
    }
    x=x1;
    while(x>=0)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else break;
      }
      x--;
    }  
    x=x1;
    while(y<8)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else break;
      }
      y++;
    }
    y=y1;
    while(y>=0)
    {
      if(board[x][y] !='.')
      {
        if(z==0)
        {
          if(board[x][y]== 'k')
            return true;
        }
        else
          if(z==1)
        {
          if(board[x][y]== 'K')
            return true;
        }
        else break;
      }
      y--;
    }
    y=y1;  
    
      if(z==0)
      board[x1][y1] = 'B';
    else
      board[x1][y1] = 'b';
    return false;
  }
  ///////////////////////////////////////
  public boolean bishop(int x, int y, int z)
  {
    int x1 = x;
    int y1 = y;
    board[x][y] = '.';
    while(x < 8 && y <8)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x++;
      y++;
    }
    x = x1;
    y = y1;
    while(x < 8 && y >=0)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x++;
      y--;
    }
    x = x1;
    y = y1;
    while(x >= 0 && y >=0)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x--;
      y--;
    }
    x = x1;
    y = y1;
    while(x >= 0 && y <8)
    {
      if(board[x][y] != '.')
      {
        if(z==0)
          if(board[x][y] == 'k')
          return true;
        if(z==1)
          if(board[x][y] == 'K')
          return true;
        break;
      }
      x--;
      y++;
    }
    x = x1;
    y = y1;
    if(z==0)
      board[x1][y1] = 'B';
    else
      board[x1][y1] = 'b';
    return false;
  }
  
  
  public void printBoard()
  {
    for(int i = 0; i < 8; i++)
    {
      for( int j = 0; j<8; j++)
      {
        System.out.print(board[i][j]+"");
      }
      System.out.println("");
    }
  }
  
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    checkTheCheck game = new checkTheCheck();
    while(in.hasNext())
    {
      for(int i = 0; i<8; i++)
      {
        String k = in.next();
        for(int j = 0; j<8; j++)
        {
          char l = k.charAt(j);
          game.board[i][j] = l;
        }
      }
      game.printBoard();
      if(game.whiteCheck())
        System.out.println("black in chaeck");
      else if(game.blackCheck())
        System.out.println("white in check");
      else System.out.println("no check");
    }
  }
}