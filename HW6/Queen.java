import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


/* Used the pseudo code at https://arstechnica.com/civis/viewtopic.php?t=766223 for help, but 
 * I was unable to print all the solutions for all N, only at most N solutions. 
 * I was trying to do it without recursion, but I think it might be needed.
 * */



public class Queen {
	private int N;
	private int array [][];

	private Queen(int N){
		this.N=N;
		array=new int[N][N]; 
	}
	private int numSol=0;
	
	private void fillArr(){
		for( int i=0; i<N; i++){
			Arrays.fill(array[i], 0);
		}
	}
	
	private ArrayList<Integer> solHolder = new ArrayList<Integer>();
	Stack<Integer> pos = new Stack<Integer>();
	
	private boolean isSafe (int row, int col){
		
		for(int i=0; i<N; i++){
			if((array[row][i] == 1) || (array [i][col]==1)){
			return false;
			
			}
		}
		
		for(int i=0; i<N; i++){
			for(int k=0; k<N; k++){
				if((i+k)==(row+col)|| (i-k)==(row-col)){
					if(array[i][k]==1){
						return false;
					}
				}
			}
		}
		return true;
	}
	

private void solveNQ(){
		fillArr();
		
		int row=0;
		int backcol=0;
		int backrow=0;
		int start=0;

		
		outer:
		do{
			
			 for(int col = start; col<N+1; col++){
				 
				 if(row==0 && start==N){
					 break outer;
				 }
				 
				 if(col < N){
					// System.out.print(row + " " +col+"\n");
				 
					 if(isSafe(row,col)== true){
						// System.out.print("placed\n");
						 array[row][col]=1;
						 pos.push(col);
						 
						 if(pos.size()==N){
							 
							 for(int i=0; i<N; i++){
								solHolder.add(pos.elementAt(i));
							 }
							 numSol++;
							 row=0;
							 start=pos.elementAt(0)+1;
							 
							 pos.clear();
							  
							 clearArr();
							 break;
						 }
						 
						  if(pos.size()!= N){
							 row++;
							 start=0;
							 break;
						 }
						 
					 }
				 }
				 
				 if(col == N){
					 if(pos.isEmpty()==true){
						 System.out.println("This is unsolvable.");
						 break outer;
					 }
					 backcol= pos.pop();
					 backrow=row-1;
					 array[backrow][backcol]=0;
					 start=backcol+1;
					 row--;
				 }
				 
				 
				 else{
					 
					 start=0;
				 }
				 
			 }
			 
			
		}while(row < N);
		
	}

	
	

	
	private void printArr(){
		int start=solHolder.size()-1;
		for(int i=0; i<numSol; i++){
			
			for(int p=0; p<N; p++){
				array[p][solHolder.get(start)]=1;
				start--;
			}
			
			for(int j=0; j<N; j++){
				for(int k=0; k<N; k++){
					System.out.print(array[j][k]+"  ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			clearArr();
		}
	}
	
	private void printList(){
		for(int t: solHolder){
			System.out.print(t);
		}
	}
	
	private void clearArr(){
		for( int i=0; i<N; i++){
			Arrays.fill(array[i], 0);
		}
	}
	
	
	public static void main(String[] args) {
		int N;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Input Size N:");
		N=sc.nextInt();
		Queen q= new Queen(N);
		
		System.out.println("\n");
		
		q.solveNQ();
		//q.printList();
		q.printArr();
	}

}
