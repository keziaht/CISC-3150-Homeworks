import java.util.concurrent.atomic.AtomicInteger;

/*Used https://defensivecode.wordpress.com/2016/03/18/3-threads-to-print-alternate-values-in-sequence-java/
		for one short code, instead of 4 runnable classes with the same code. 
*/

public class ABC {
	
	String list[] = {"A","B","C","D","E","F","G","H","I",
				    "J","K","L","M","N","O","P","Q",
				      "R","S","T","U","V","W","X","Y","Z",
				        "THANKS","FOR","PLAYING"}; 
	
	public static void main(String[] args) {
	
		AtomicInteger counter = new AtomicInteger (0);
				
		printABC t1p = new printABC(0, counter);
		printABC t2p = new printABC(1, counter);
		printABC t3p = new printABC(2, counter);
		printABC t4p = new printABC(3, counter);
		
		Thread t1 = new Thread(t1p);
		Thread t2 = new Thread(t2p);
		Thread t3 = new Thread(t3p);
		Thread t4 = new Thread(t4p);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}

class printABC implements Runnable{
	
		 int threadpos;
		 AtomicInteger counter;
		
		ABC abc= new ABC();
		
		public printABC(int threadpos, AtomicInteger counter){
			this.threadpos=threadpos;
			this.counter=counter;
		}
	
	@Override
	public void run() {
		
		while(true){
			synchronized(counter){
				int num=counter.intValue();
					
					if (num == 29){
						counter.notifyAll();
						break;
					}
					
					if((num%4) == threadpos){
						 System.out.println(Thread.currentThread().getName()+
							 " printing: "+ abc.list[num]);
						 counter.incrementAndGet();
		
					 }
					 counter.notifyAll();
				 	 
					 try{	 
						 counter.wait();
					 }
					 catch(InterruptedException e){}
			}
		}
	}
}
