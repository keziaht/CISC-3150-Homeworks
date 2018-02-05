import java.util.*;


public class Area {
	
	public static void main(String[] args){
		Scanner radius = new Scanner(System.in);;
		int r;
		double area;
		
		System.out.println("Enter Radius:"+ "\t");
		while (radius.hasNextLine()){
			
			try{
				r=radius.nextInt();
				area= Math.PI * Math.pow(r, 2);
			
				System.out.print("The Area = "+ area + "\n\n");
				System.out.println("Enter Radius:"+ "\t");
			}
		
			catch (NoSuchElementException e){
				System.out.println("Wrong Input Type \n\n" +"Enter Radius:"+ "\t");
			}
			finally{
				
				radius.nextLine();
			}
		}
	}

}
