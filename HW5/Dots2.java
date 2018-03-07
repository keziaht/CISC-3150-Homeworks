import java.util.*;
import java.util.concurrent.*;




//Used code from https://stackoverflow.com/questions/32050496/how-do-you-calculate-percentages-in-java/32050547 to implement multithreading
public class Dots2 implements Runnable{
	
	private long total;
	
	private double cirx=0D;
	private double ciry=0D;
	private double radius;
	
	private double powr;
	
	private long inside=0L;
	
	private double dotx;
	private double doty;
		
	private double powx;
	private double powy;
	
	
	public Dots2(long total, double radius){
		this.total=total;
		this.radius=radius;
		this.powr=radius*radius;
	}
	
	public void run() {
		
		 ThreadLocalRandom r = ThreadLocalRandom.current();
		 
		 
		 for(long i=0; i<total; i++) {
			 
			 	dotx= r.nextDouble()*(radius-cirx)+cirx;
				doty= r.nextDouble()*(radius-ciry)+ciry;
				
				powx= (dotx-cirx)*(dotx-cirx);
				powy= (doty-ciry)*(doty-ciry);
				
				if((powx +powy )<= powr ){
						inside++;
					}
		    }
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		 
		 long before = System.currentTimeMillis();
		
		 long total = 4000000000L;
		 float perc =0f;
		 
		 double radius= 10D;
		 int cores = Runtime.getRuntime().availableProcessors();
		 long result =0L;
		 
		 List<Dots2> dotsList = new ArrayList<Dots2>();
		 List<Thread> threadList = new ArrayList<Thread>();
		 
		 for(int i=0; i<cores; i++){
			 
			 Dots2 dots = new Dots2((total/cores),radius);
			 dotsList.add(dots);
			 Thread thread = new Thread(dots);
			 thread.start();
			 threadList.add(thread);
		 }
		 
		 for(Thread t: threadList){
			 t.join();
		 }
		 for(Dots2 d: dotsList){
			 result += d.inside;
		 }

		 perc = ((result*100f)/total);
			
		System.out.println(perc +"% is within the circle"+"\n Total Time: "+(System.currentTimeMillis()-before)+" milis");

	}


}
