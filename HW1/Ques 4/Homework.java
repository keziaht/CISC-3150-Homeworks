import java.io.*;



public class Homework {
	
	//Used https://codescracker.com/java/program/java-program-read-and-display-file.htm to brush up on reading files.
	
	public static void main(String [] args){
		
		String file= null;
		InputStreamReader instream= new InputStreamReader(System.in);
		BufferedReader buffered= new BufferedReader(instream);
		
		try {
			
			while((file=buffered.readLine())!= null){
					
				System.out.println(file);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
