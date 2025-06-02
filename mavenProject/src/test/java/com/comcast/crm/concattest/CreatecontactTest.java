package com.comcast.crm.concattest;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.com.objectrepositoryutility.Createnewcontactpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.contactpage;
import com.comcast.crm.basetest.Baseclass;

/**
 * test class for contact module
 * @author Rupali
 */

 @Test(groups = {"smoke","regression"})
public class CreatecontactTest extends Baseclass {

	@Test
	public void createContactTest1() throws EncryptedDocumentException, IOException, InterruptedException {
		String lastname = elib.getdatafromExcel("contact", 1, 2) + jlib.getrandomnum();

		Homepage hp = new Homepage(driver);
		hp.getContactlnk().click();

		contactpage cp = new contactpage(driver);
		cp.getCreateconbtn().click();

		Createnewcontactpage cnop = new Createnewcontactpage(driver);
		cnop.getLastnametxtfield().sendKeys(lastname);
		cnop.getSavebtn().click();
        
		Thread.sleep(2000);
		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actlastname.equals(lastname)) {
			System.out.println(lastname + "information is verified==pass");
		} else {
			System.out.println(lastname + "information is not verified");
		}

	}
	
	
	@Test(groups = {"regression"})
	public void createContactWithSupportDateTest() throws Throwable {
		String lastname=elib.getdatafromExcel("contact" , 1, 2)+ jlib.getrandomnum();
		
		Homepage hp=new Homepage(driver);
		hp.getContactlnk().click();
		
		contactpage cp=new contactpage(driver);
		cp.getCreateconbtn().click();
		
		Thread.sleep(2000);
		String Startdatee = jlib.getSystemDateyyyyddmm();
		
		Thread.sleep(2000);
		String enddatee = jlib.getRequiredDateyyyyddmm(30);
		
		Thread.sleep(2000);
		Createnewcontactpage cncp=new Createnewcontactpage(driver);
		cncp.getLastnametxtfield().sendKeys(lastname);
		
		Thread.sleep(2000);
		cncp.createContactWithStartDate(Startdatee);
		cncp.createcontactwithenddate(enddatee);
		cncp.getSavebtn().click();
	
		
		Thread.sleep(2000);
		String actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartdate.equals(Startdatee))
		{
			System.out.println(Startdatee + "information is verified==pass");
		}
		else {
			System.out.println(Startdatee + "information is not verified");
		}
		
		 Thread.sleep(2000);
			String actenddate= driver.findElement(By.id("dtlview_Support End Date")).getText();
			if(actenddate.equals(enddatee))
			{
				System.out.println(enddatee + "information is verified==pass");
			}
			else {
				System.out.println(enddatee + "information is not verified");
			}
	}
	
	@Test(groups = {"smoke"})
	public void createContactwithPhoneno() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String lastname = elib.getdatafromExcel("contact", 10, 2) + jlib.getrandomnum();
		String phoneno=elib.getdatafromExcel("contact",10,3);

		Homepage hp = new Homepage(driver);
		hp.getContactlnk().click();

		contactpage cp = new contactpage(driver);
		cp.getCreateconbtn().click();

		Createnewcontactpage cnop = new Createnewcontactpage(driver);
		cnop.getLastnametxtfield().sendKeys(lastname);
		cnop.createConwithPhone(phoneno);
		cnop.getSavebtn().click();
	
	
	Thread.sleep(2000);
	String actphone = driver.findElement(By.id("dtlview_Mobile")).getText();
	if(actphone.equals(phoneno))
	{
		System.out.println(phoneno + "is verified==pass");
	}
	else {
		System.out.println(phoneno + "is not verified==faill");
	}
	

	}
}
