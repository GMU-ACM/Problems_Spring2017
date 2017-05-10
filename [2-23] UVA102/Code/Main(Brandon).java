import java.util.Scanner;
//102
class Main{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		
		Bin b1 = new Bin(input[0],input[1],input[2]);
		b1.num = 1;
		Bin b2 = new Bin(input[3],input[4],input[5]);
		b2.num = 2;
		Bin b3 = new Bin(input[6],input[7],input[8]);
		b3.num = 3;
		
		Bin brown, green, clear;
		//bgc - bcg - gcb - gbc - cbg - cgb
		
		String[] answers = {"BGC", "BCG", "GCB", "GBC", "CBG", "CGB"};
		int total[] = new int[6];
		//bgc
		brown = b1; green = b2; clear = b3;
		total[0] += brown.green + brown.clear + green.brown + green.clear + clear.brown + clear.green;

		//bcg
		clear = b2; green = b3;
		total[1] += brown.green + brown.clear + green.brown + green.clear + clear.brown + clear.green;

		//gcb
		green = b1; clear = b2; brown = b3;
		total[2] += brown.green + brown.clear + green.brown + green.clear + clear.brown + clear.green;

		//gbc
		brown = b2; clear = b3;
		total[3] += brown.green + brown.clear + green.brown + green.clear + clear.brown + clear.green;

		//cbg
		clear = b1; green = b3;
		total[4] += brown.green + brown.clear + green.brown + green.clear + clear.brown + clear.green;

		//cgb
		green = b2; brown = b3;
		total[5] += brown.green + brown.clear + green.brown + green.clear + clear.brown + clear.green;

		int temp = total[0];
		int id = 1;
		for(int i=0;i<total.length;i++){
			if(total[i] < temp){
				temp = total[i];
				id = i;
			}
		}
		System.out.println(answers[id] + " " + temp);
	}

	public static class Bin{
		int num;
		int green;
		int brown;
		int clear;
		public Bin(int b, int g, int c){
			green = g;
			brown = b;
			clear = c;
		}

		public Bin(String b, String g, String c){
			green = Integer.parseInt(g);
			brown = Integer.parseInt(b);
			clear = Integer.parseInt(c);
		}

		public Bin clone(){
			return new Bin(this.brown, this.green, this.clear);
		}
	}
}
