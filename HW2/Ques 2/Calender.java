import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calender {
	static String[][] month = new String[7][6];
	static Calendar cal = new GregorianCalendar();
	static String[] firstDay= new String[]{"Su","Mo","Tu","We","Th","Fr","Sa"};
	
	public static void printMonth(int startday, int mlength){
		
		int count=1;
		int lead=1;
		
		for (int i=0; i < 6; i++){
			for(int j=0; j< 7; j++){
				
				if(lead < startday){
					month[j][i]="   ";
					lead++;
				}
				
				else{
					if(count<=mlength){
						if(count<10)
							month[j][i]="  "+Integer.toString(count);
						if(count>=10)
							month[j][i]=" "+Integer.toString(count);
						count++;
						}
					else{
						month[j][i]=" ";
						
					}
				}
				 
				 System.out.print(month[j][i]);
			}
			System.out.print("\n");
		}
	}
	public static int calcStart(int prevstart,int max){
		int newstart=prevstart;
		
		for(int i = 0; i < max; i++){
			
			if(newstart<7){
			   // System.out.println(newstart);
				newstart++;
			}
			else if(newstart==7){
				//System.out.println(newstart);
				newstart=1;
			}
			
		}
		
		return newstart;
	}
	//Used the Calendar class to not re-invent the wheel
	public static Boolean isLeap(int year){
		return ((GregorianCalendar) cal).isLeapYear(year);
	}
	
	public static int daytoNum(String day){
		int count=1;
		int test=0;
		for(String r: firstDay){
			test=day.compareTo(r);
			if(test==0){
				return count;
			}
			count++;
		}
		return 1;
	}
	
	public static void printitAll(int start, int year){
		System.out.println("     January "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,31);
		start=calcStart(start,31);
		
		if(isLeap(year)==false){
			System.out.println("     Feburary "+year);
			System.out.println(" Su Mo Tu We Th Fr Sa");
			printMonth(start,28);
			start=calcStart(start,28);
		}
		else{
			System.out.println("     Feburary "+year);
			System.out.println(" Su Mo Tu We Th Fr Sa");
			printMonth(start,29);
			start=calcStart(start,29);
		}
		
		System.out.println("     March "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,31);
		start=calcStart(start,31);
		
		System.out.println("     April "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,30);
		start=calcStart(start,30);
		
		System.out.println("     May "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,31);
		start=calcStart(start,31);
		
		System.out.println("     June "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,30);
		start=calcStart(start,30);
		
		System.out.println("     July "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,31);
		start=calcStart(start,31);
		
		System.out.println("     August "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,31);
		start=calcStart(start,31);
		
		System.out.println("     September "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,30);
		start=calcStart(start,30);
		
		System.out.println("     October "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,31);
		start=calcStart(start,31);
		
		System.out.println("     November "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,30);
		start=calcStart(start,30);
		
		System.out.println("     December "+year);
		System.out.println(" Su Mo Tu We Th Fr Sa");
		printMonth(start,31);
		start=calcStart(start,31);
	}

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String firstDaypick;
		int start;
		int year;
		
		System.out.println("What day did the 1st of January fall on? Enter: Su Mo Tu We Th Fr Sa");
		firstDaypick= sc.nextLine();
		start=daytoNum(firstDaypick);
		
		System.out.println("What year is it?:");
		year=sc.nextInt();
		
		sc.close();
		
		printitAll(start,year);
		
	}

}
