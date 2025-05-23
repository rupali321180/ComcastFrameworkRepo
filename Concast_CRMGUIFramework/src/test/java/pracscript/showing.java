package pracscript;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.comcast.com.objectrepositoryutility.Createnewcontactpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.contactpage;
import com.comcast.crm.basetest.Baseclass;

public class showing  extends Baseclass{
	@Test
	public void createContactWithorgTest() throws Throwable
	{
		String orgName=elib.getdatafromExcel("contact" , 7, 2)+ jlib.getrandomnum();
		String contactLastname=elib.getdatafromExcel("contact" , 7, 3);
		
		Homepage hp=new Homepage(driver);
		hp.getContactlnk().click();
		
		contactpage cp=new contactpage(driver);
		cp.getCreateconbtn().click();
		
		
		Createnewcontactpage cnop = new Createnewcontactpage(driver);
		cnop.createContactWithName(contactLastname);
	    cnop.getSelectbtn().click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("search_txt")).sendKeys(orgName,Keys.ENTER);
		 Thread.sleep(2000);
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='"+ orgName +"']")).click();
		 
		cnop.getSavebtn().click();
		
		
		
		Thread.sleep(2000);
		String actname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actname);
		
		if(actname.trim().equals(orgName))
		{
			System.out.println(orgName + "is created==pass");
		}
		else {
			System.out.println(orgName + "is not created");
			System.out.println(orgName + "is not created");
			
			
		}
		
	}
	
	@Test
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
