import java.util.Scanner;
import java.lang.Math;

public class PrimeLandSubtract
{
    public static void main (String[ ] args)
    {        
        int initial = 1;
        int result;       
        String output = "";
        
        //Take input line.
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
                
        //Change prime number system to decimal.
        for (int i = 0; i < input.length; i += 2)
        {
            int n1 = Integer.parseInt(input[i]);
            int n2 = Integer.parseInt(input[i+1]);
            
            int temp = (int) Math.pow(n1, n2);
            initial *= temp;                 
        }
        
        //Subtract 1 to inital input.
        result = initial - 1;
        
        //Do the prime factorization.
        for(int i = 2; i <= result; i++)
        {
            int count = 0;
            
            //Check if the number is divisible by other numbers.
            while (result % i == 0 && result > 1)
            {
                result = result / i;
                count++;
            }

            // Add the current calculation to the string.
            if (count != 0)
            {
                output = i + " " + count + " " + output;
            }       
            
        }
        
        //Print output.
        System.out.println(output);
    
    }
    
}