import java.util.*;

public class Circle {
	
		int x;
		int y;
		int rad;
	
	public static void main(String[] args) {
		
		Circle[] circle=new Circle[2];
		
		Scanner input= new Scanner(System.in);
		
		
		for(int i=0; i< circle.length; i++){
			circle[i]= new Circle();
			
			System.out.println("Enter Center Cooridnates: \t\n");
			circle[i].x = input.nextInt();
			circle[i].y = input.nextInt();
			
			System.out.println("Enter Radius: \t\n");
			circle[i].rad =input.nextInt();
			
		}
		
		 input.close();
		
		 double distance=getDist(circle[0].x,circle[1].x,circle[0].y,circle[1].y);
		 
		 testCircles(distance, circle[0].rad, circle[1].rad);
		 
		
	}
	public static double getDist(int x1, int x2, int y1, int y2){
		return Math.sqrt(Math.pow((x1- x2),2) +Math.pow((y1-y2), 2));
	}
	
	// Used https://stackoverflow.com/questions/9486520/finding-if-a-circle-is-inside-another-circle for help with inside
	public static void testCircles(double distance, int rad1, int rad2){
		
		if(distance > (rad1+rad2)){
			System.out.println("The Circles are separate");
			}
		
			else if(distance <= Math.abs(rad1-rad2)|| distance <= Math.abs(rad2-rad1)){
				System.out.println("One Circle is inside another");
			}
		
			else if (distance == Math.abs(rad1+rad2)){
				System.out.println("The Circles are just touching");
			}
		
			else {
				System.out.println("The Circles are overlapping");
				}
				
	}

}
