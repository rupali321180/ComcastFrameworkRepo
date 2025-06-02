package com.concast.com.generic.webdriverutility;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;


public class Javautility {

	public int getrandomnum()
	{
		Random random=new Random();
		int randomnum=random.nextInt(5000);
		return randomnum;
	}
	public String getSystemDateyyyyddmm()
	{
		Date dateobj=new Date();
		
		// format the date into a specific pattern
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date1=sdf.format(dateobj);
		return date1;
	}
	public String getRequiredDateyyyyddmm(int days)
	{
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startdate=sim.format(dateobj);
		
		// This calendar is automatically set to the current date 
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate=sim.format(cal.getTime());
		return reqdate;
	}
	
	
	
	
	
	
}
