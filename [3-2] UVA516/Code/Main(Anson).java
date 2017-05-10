import java.util.*;

//Problem 561 - Prime Land
//I think it works?

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			String line = s.nextLine();
			String[] sNums = line.split(" ");
			if (sNums.length == 1) {
				break;
			}
			int total = 1;
			for (int i = 0; i < sNums.length; i+=2) {
				for (int j = 0; j < Integer.parseInt(sNums[i+1]); j++) {
					total *= Integer.parseInt(sNums[i]);
				}
			}
			total--;
			ArrayList<String> counts = new ArrayList<String>();
			int prime = 2;
			while (total > 1) {
				if (total%prime == 0) {
					String out = "";
					out += prime + " ";
					int count = 0;
					while (total%prime == 0) {
						total /= prime;
						count++;
					}
					out += count;
					counts.add(out);
				}
				prime++;
			}
			String done = "";
			for (int i = counts.size()-1; i >= 0; i--) {
				done += counts.get(i);
				if (i != 0) {
					done += " ";
				}
			}
			System.out.println(done);
		}
	}
}
