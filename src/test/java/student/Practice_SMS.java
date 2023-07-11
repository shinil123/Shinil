package student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//interview version 3.141.59 version selenium
public class Practice_SMS 
{
	public static void main(String[] args) 
	{
		//To get today's date with time
		Date date=new Date();
		System.out.println(date);
		
		//To go ahead 30 days from Today
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String pfdata=sdf.format(date);
		System.out.println(pfdata);
		
		// To get only date of 30 days from today
//		Calendar cal=Calendar.getInstance();
//		cal.add(Calendar.DATE,30);
//		Date date1=cal.getTime();
//		System.out.println(date1);
		
	}

}
