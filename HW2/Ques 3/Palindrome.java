import java.util.Scanner;

public class Palindrome {
	
	public static Boolean Paltest(String s){
			for(int i=0; i<s.length()/2; i++){
				int end=s.length()-i-1;
			
				if(s.charAt(i)!= s.charAt(end)){
					return false;
				}

			}
			return true;
		}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		
		String test= sc.nextLine();
		sc.close();
		
		Boolean outcome=Paltest(test);

		if(outcome==false)
			System.out.println("This is not a Palindrome");
		else
			System.out.println("This is a Palindrome");
	}

}
