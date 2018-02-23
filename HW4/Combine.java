import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combine {

	public static void main(String[] args) {
		
		  int rows;
		  Scanner sc= new Scanner(System.in);
		  System.out.println("Enter how many rows for 2D arrayof characters:");
		  
		  rows= sc.nextInt();
		  
		  char test[][]= new char[rows][];
		  String input="";
		  
		  for(int i=0; i<rows; i++){
			  System.out.println("Fill out row: "+ (i+1));
			  input=sc.next();
			  	
			  	for(int x=0; x<input.length(); x++){
			  		
			  		test[i]=input.toCharArray();
			  	}
		  }
		  sc.close();
		  
		printCombine(test);
	}
	
	
	//I used the logic from https://stackoverflow.com/questions/15868914/how-to-get-2d-array-possible-combinations/15869610 
	//for figuring out how get proper combinations for 2d arrays with various sizes. 
	
	public static void printCombine(char test[][]){
		
		StringBuilder sb = new StringBuilder();
		
		
		int start=0;
		int total=1;
		
		for(int i= 0; i<test.length; i++){
			total *= test[i].length;
		}
		
		
		List<String> results= new ArrayList<String>((int) total);
		
		Integer combination[]= new Integer[test.length];
		
		for(int i=0; i<combination.length; i++){
				combination[i]=0;
			}
		
		do{	
			
			sb = new StringBuilder();
			
			
			for(int i=0; i<test.length; i++){
				sb.append(test[i][combination[i]]);
			}
			results.add(sb.toString());
			
			for (int x=test.length-1; x>=0; x--){
				
				if (combination[x] < test[x].length-1){
						++combination[x];
						break;
				}
				
				combination[x]=0;
			}
			
			start++;
		}
		while(start < total);
		
		for(String r: results){
					System.out.println(r);
				}
		
	}	

}
