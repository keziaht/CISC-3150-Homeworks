import java.util.Random;

public class Dots {

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		
		long total=4000000000L;
		float perc=0f;
		
		double cirx=0D;
		double ciry=0D;
		double rad=10D;
		
	
		double dotx;
		double doty;
		
		double powx;
		double powy;
		double powr=rad*rad;
		
		Random r= new Random();
		
		long inside=0L;
		
		
		
		for(long i=0L; i<total; i++){
			
			dotx =  r.nextDouble()*(rad-cirx)+cirx;
			doty =  r.nextDouble()*(rad-ciry)+ciry;
			
			powx=(dotx-cirx)*(dotx-cirx);
			powy=(doty-ciry)*(doty-ciry);
			
			if((powx+powy)<=powr){
				inside++;
			}
		}
		
		perc = ((inside*100f)/total);
		
		System.out.println(perc +"% is within the circle"+"\n Total Time: "+(System.currentTimeMillis()-before)+" milis");

	}

}
