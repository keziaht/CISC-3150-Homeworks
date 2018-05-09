import java.io.File;
import java.io.FileNotFoundException;

public class Files {

	static int space=1;
	
	public static void fixDir(File dir, int space)throws FileNotFoundException{
	
	
		if(!dir.exists())
			throw new FileNotFoundException("No Such File or Diretory");
	
		String res= "|____"+dir.getName();
	
		System.out.printf("%"+space+"s"," ");
		System.out.println(res);
		
		for(File f: dir.listFiles()){
		
		
		
			if(f.isDirectory()){
			
				fixDir(f, space+2);
			}
			else{
			
				fixFile(f, space+2);
			}
		}
	}
	
		public static void fixFile(File file, int space){
		
		
			String res= "|____"+file.getName();
			System.out.printf("%"+space+"s", " ");
			System.out.println(res);
		}
	
	
	
	
		public static void main(String[] args) {
		
			String path = "C:\\Users\\keziah\\Desktop\\HW1";
		
			File file= new File(path);
		
			try {
				fixDir(file, space);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		}

}
