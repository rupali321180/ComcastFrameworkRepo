package pracscript;

import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.comcast.com.objectrepositoryutility.ChildOrgPage;
import com.comcast.com.objectrepositoryutility.Createnewcontactpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.contactpage;
import com.comcast.crm.basetest.Baseclass;
import com.concast.com.generic.webdriverutility.Webdriverutility;


public class contactTest  extends Baseclass {
	@Test
	public void createContactWithorgTest() throws Throwable
	{
		Webdriverutility wlib=new Webdriverutility();
		
		String orgName=elib.getdatafromExcel("contact" , 7, 2)+ jlib.getrandomnum();
		String contactLastname=elib.getdatafromExcel("contact" , 7, 3);
		
		Homepage hp=new Homepage(driver);
		hp.getContactlnk().click();
		
		contactpage cp=new contactpage(driver);
		cp.getCreateconbtn().click();
		
		
		Createnewcontactpage cnop = new Createnewcontactpage(driver);
		cnop.createContactWithName(contactLastname);
	    cnop.getSelectbtn().click();
	    wlib.switchtotabonurl(driver, "module=Accounts&action");
	    
	    ChildOrgPage cop=new ChildOrgPage(driver);
	    cop.getSearchfield().sendKeys(orgName);
	    cop.getSearchbtn().click();
	    Thread.sleep(2000);
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='"+ orgName.trim() +"']")).click();
	    wlib.switchtotabonurl(driver,"module=Contacts&action");
	    cnop.getSavebtn().click();
	    String actualLastName = cnop.getActulLastName().getText();
	    wlib.verifyEquals(actualLastName, contactLastname);
	    String actualheadermsg = cnop.getHeadermsg().getText();
	    wlib.verifyEquals(actualheadermsg, contactLastname);
	    
	    
	    
	    
	}
	
}
	
	
	
	
//	@Test
//	public String getRequiredDateyyyyddmm(int days) {
//		Date dateobj = new Date();
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		String startdate = sim.format(dateobj);
//
//		// This calendar is automatically set to the current date
//		Calendar cal = sim.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH, days);
//		String reqdate = sim.format(cal.getTime());
//		return reqdate;
//	}


