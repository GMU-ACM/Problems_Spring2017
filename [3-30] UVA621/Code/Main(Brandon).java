import java.util.*;
class Main{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int numlines = Integer.parseInt(scan.nextLine());
		for(int i = 0; i < numlines; i++){
			String line = (scan.nextLine()).trim();	
			int number = Integer.parseInt(line);
			switch(number){
				case 1:
				case 4:
				case 78:
					System.out.println("+");
					break;
				default:
					if(line.substring(line.length()-2).equals("35")){
						System.out.println("-");
					}else if(line.charAt(0)=='9' && line.charAt(line.length()-1)=='4'){
						System.out.println("*");
					}else if(line.indexOf("190")==0){
						System.out.println("?");
					}	
					break;
			}
		}
	}
}
