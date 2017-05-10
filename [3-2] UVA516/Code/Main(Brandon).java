import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String l = scan.nextLine();
		
		while(!l.trim().equals("0")){
			String[] line = l.split(" ");
			int product = 1;
			for(int i=0;i<line.length-1;i+=2){
				product *= (int)Math.pow(Integer.parseInt(line[i]), Integer.parseInt(line[i+1]));
			}
			product--;
			
			String answer = "";
			for(int i=2;i<=product;i++){
		//		System.out.println(i);
				int counter = 0;
				while(product%i==0){
					counter++;
					product = product / i;
					
				//	System.out.println("\t"+product);
				}if(counter != 0){
					answer = i + " " + counter + " " + answer;
				}
			}

			System.out.println(answer.trim());
			l = scan.nextLine();
		}
	}

	public static boolean isPrime(int n){
		if(n<2)
			return false;
		if(n==2)
			return true;
		for(int i = 3; i*i < n; i+=2){
			if(i%n==0)
				return false;
		}
		return true;
	}
}
