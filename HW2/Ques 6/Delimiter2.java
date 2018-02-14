import java.util.Scanner;

public class Delimiter2 {

	public static void main(String[] args) {
		
		Scanner sc=  new Scanner(System.in);
		sc.useDelimiter("");
		
		System.out.println("Type a String:");
		
		while (sc.hasNextLine()){
			System.out.println(sc.next());
		}
		sc.close();
	}

}
