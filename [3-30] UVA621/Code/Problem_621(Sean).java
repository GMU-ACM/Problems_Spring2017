import java.util.*;
import java.io.*;


public class Problem_621 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfInputs = sc.nextInt();

		String currentNum = "";
		String result = "";
		for(int i = 0; i < numOfInputs; i++) {

			currentNum = sc.next();

			if(currentNum.equals("1") || currentNum.equals("4") || currentNum.equals("78")) {
				result += "+\n";
			}
			else if(currentNum.substring(currentNum.length() - 2).equals("35")) {
				result += "-\n";
			}
			else if(currentNum.substring(0, 1).concat(currentNum.substring(currentNum.length() - 1)).equals("94")) {
				result += "*\n";
			}
			else {
				result += "?\n";
			}
		}
		System.out.println(result);
	}
}
