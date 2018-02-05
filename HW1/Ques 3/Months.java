import java.util.Random;

public class Months {
	
	
	private String[] list_of_Months= {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
	private int number;
	
	Random rand= new Random();
	
	public void PickRandom(){
		
		number= rand.nextInt(12);
		
		System.out.print(number+1 + "\t"+ list_of_Months[number]);
	}
	
	public static void main(String [] args ){
		
		 Months p = new Months();
		 
		 p.PickRandom();
	}

}
