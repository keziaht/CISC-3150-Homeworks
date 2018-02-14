import java.util.Scanner;

//Formating issues when level is greater than 100
public class Pyramid {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int level;
		int countdown=1;
		int add=1;
		String output="";
		
		System.out.println("Enter a level:");
		level=sc.nextInt();
		sc.close();
		
		for(int i=1; i<level+1; i++){
			int countup=1;
			int length = (i*2)-1;
			int turn= (i*2)/2;
			countdown=turn;
			for(int y=0; y<length; y++){
				
				if(countup < turn){
					output=output+Integer.toString(countup)+" ";
				}
				if(countup >= turn){
					output=output+Integer.toString(countdown)+" ";
					countdown--;
				}
				countup++;
			}
			// Used https://stackoverflow.com/questions/48375160/simple-java-pyramid-using-system-out-printf-to-format-output for help with printf formating
			if(turn<10){
				System.out.printf("%"+((level*3)+(i*2))+"s\n",output);
				output="";
			}
			if(turn>=10){
				System.out.printf("%"+((level*3)+(i*2)+ add)+"s\n",output);
				add=(add*2)/2;
				add++;
				output="";
			}
		}

	}

}
