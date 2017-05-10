import java.io.*;
import java.util.*;

public class Problem_151 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n;
		int m;
		
		ArrayList<Integer> test = new ArrayList<Integer>();

		while(true){
			boolean stop = false;

			n = sc.nextInt();
			m = 1;
			if(n == 0) {
				break;
			}

			while(!stop) {

				ArrayList<Integer> numberPool = new ArrayList<Integer>();
				for(int i = 1; i <= n; i++) {
					numberPool.add(i);
				}
				while(numberPool.size() > 1) {
					//Remove from arraylist until only one element remains and that element is 13.
					
				}
				if(numberPool.get(0) == 13) {
					System.out.println(m);
					stop = true;
				}
				m++;
			}

		}
	}
}