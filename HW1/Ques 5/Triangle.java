import java.util.*;


public class Triangle {
	
	private int x;
	private int y;
	
	public Triangle(){
		this.x=0;
		this.y=0;
	}
	
	public void setXCor(int x){
		 this.x = x;
	}
	public void setYCor(int y){
		 this.y = y;
	}
	public int getX(){
		 return x;
	}
	public int getY(){
		 return y;
	}
	
	 public static  double getSideLength(int x1, int x2, int y1, int y2){
				double side= Math.sqrt(Math.pow((x1- x2),2) +Math.pow((y1-y2), 2));
				System.out.print(side+ "\t");
				return side;
				
		}
	 
	 public static void isReal(double side1,double side2, double side3){
		 
		 if((side1+side2) > side3 && (side2+side3) > side1 && (side1+side3) > side2){
			 
			System.out.println("Is a triangle");
		 }
			 
		 
		 else
			 System.out.println("Is not a triangle");
	 }
	 
	public static void main(String[] args){
		
		Triangle[] tri= new Triangle [3];
		
		Scanner input = new Scanner(System.in);
		
		
			for(int i= 0; i < tri.length; i++){
				
				tri[i]= new Triangle();
				System.out.println("Enter coordinates: \t");
				tri[i].setXCor(input.nextInt());
				tri[i].setYCor(input.nextInt());
				
			}
			input.close();
			
			
			
			double side1= getSideLength(tri[0].getX(), tri[1].getX(),tri[0].getY(), tri[1].getY());
			double side2 = getSideLength(tri[1].getX(), tri[2].getX(),tri[1].getY(), tri[2].getY());
			double side3= getSideLength(tri[2].getX(), tri[0].getX(),tri[2].getY(), tri[0].getY());
			
			isReal(side1,side2,side3);
			
	}
}
