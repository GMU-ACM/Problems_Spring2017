import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner x = new Scanner(System.in);
		int num_inputs = Integer.parseInt(x.nextLine());
		for(int i =0;i<num_inputs;i++){	//For each test case
			int upper_b = Integer.parseInt(x.nextLine());
			
			for(int j = upper_b; j >= 0; j--){ //because we are looking for the largest, count down
				String num = j+"";
				char lastChar = num.charAt(0);
				boolean tidy = true;
				for(int k=1;k<num.length();k++){ //iterate through chars in String
					if(lastChar > num.charAt(k)){ //Not tidy
						tidy = false;
						break;
					}
					lastChar = num.charAt(k);
				}
				if(tidy){
					System.out.println("Case #"+i+": "+num);
					break;
				}
			}
		}
	}
}