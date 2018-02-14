import java.util.Scanner;

public class Delimiter {

	public static void main(String[] args) {
		
		Scanner sc=  new Scanner(System.in);
		sc.useDelimiter(", |\\n");
		
		System.out.println("Type String:");
		
		while (sc.hasNextLine()){
			System.out.println(sc.next());
		}
		sc.close();
	}

}
