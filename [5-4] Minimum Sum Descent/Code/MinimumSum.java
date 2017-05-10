import java.io.*;

public class MinimumSum
{
    public static void main(String args[])
    {
        int T;              //Number of test cases.
        int N;              //Number of line of inputs.
        int ARRAY_SIZE;     //Size of Array.
        int min = 0;        //MinimumSum.

        try
        {
            //Read in input file.
            FileReader in = new FileReader(args[0]);
            BufferedReader inFile = new BufferedReader(in);

            //Read the first variable which is the number of test cases.
            T = Integer.parseInt(inFile.readLine());

            System.out.println("OUTPUT\n");
            //Loop T times.
            for (int i = 0; i < T; i++)
            {
                N = Integer.parseInt(inFile.readLine());
                ARRAY_SIZE = N * (N + 1) / 2;

                int[] intArray = new int[ARRAY_SIZE];
                int temp = 0;
                int temp2 = 0;

                //Loop N times.
                for (int j = 0; j < N; j++)
                {
                    String[] strArray = inFile.readLine().split(" ");

                    for (int k = 0; k < strArray.length; k++)
                    {
                        if (j != 0)
                        {
                            temp = j * (j + 1) / 2;
                            temp2 = (j - 1) * j / 2;
                        }

                        if (k == 0)
                        {
                            intArray[temp] = Integer.parseInt(strArray[k]) + intArray[temp2];
                        }
                        else if (k == strArray.length - 1)
                        {
                            intArray[temp + k] = Integer.parseInt(strArray[k]) + intArray[temp - 1];
                        }
                        else
                        {
                            //System.out.println("temp2 + k - 1 = " + (temp2 + k - 1));
                            if (intArray[temp2 + k - 1] >= intArray[temp2 + k])
                            {
                                intArray[temp + k] = Integer.parseInt(strArray[k]) + intArray[temp2 + k];
                            }
                            else
                            {
                                intArray[temp + k] = Integer.parseInt(strArray[k]) + intArray[temp2 + k - 1];
                            }
                        }

                        if (j == (N - 1))
                        {
                            if (min == 0)
                            {
                                min = intArray[temp + k];
                            }
                            else if (min > intArray[temp + k])
                            {
                                min = intArray[temp + k];
                            }
                        }

                    }

                }

                System.out.println("Case#" + (i + 1) + ": " + min);

            }

            //Close input file.
            inFile.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}