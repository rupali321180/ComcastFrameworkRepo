package asertscriptpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.testng.annotations.Test;

/**
 * test class for capture the time
 * @author
 */


public class Capturetimestamp {
   @Test
	public static void main(String[] args) {
		String time=new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(time);
		
	}
	@Test()
	public void getSystemDateyyyyddmm()
	{
		Date dateobj=new Date();
		System.out.println(dateobj);
		
}
	@Test
	public void getRequiredDateyyyyddmm(int days)
	{
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startdate=sim.format(dateobj);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate=sim.format(cal.getTime());
		System.out.println(reqdate);
	}
	}

