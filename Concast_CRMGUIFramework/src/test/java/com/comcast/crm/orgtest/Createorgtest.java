package com.comcast.crm.orgtest;


import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.com.objectrepositoryutility.CreateNeworgpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.Organizationpage;
import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.listenerutility.UtilityClassObject;

//@Listeners(com.comcast.crm.listenerutility.ListenerIMPclass.class)
@Test
public class Createorgtest extends Baseclass {
	
 ExtentTest test;
	//utilityclassobject.gettest().log(status.info,"read data from excel)
	@Test
	public void createorgtest1() throws EncryptedDocumentException, IOException, InterruptedException {
	
		
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		   //ListenerIMPclass.test.log(Status.INFO,"read data from excel");
		String orgName = elib.getdatafromExcel("Org", 4, 2) + jlib.getrandomnum();


		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		   //ListenerIMPclass.test.log(Status.INFO,"navigate to org page");
		Homepage hp = new Homepage(driver);
		hp.getOrglink().click();


		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		 //  ListenerIMPclass.test.log(Status.INFO,"navigate to create org page");
		Organizationpage op = new Organizationpage(driver);
		op.getCreateorgbtn().click();


		UtilityClassObject.getTest().log(Status.INFO,"create org");
		  // ListenerIMPclass.test.log(Status.INFO,"create org");
		CreateNeworgpage cnop = new CreateNeworgpage(driver);
		cnop.createneworg(orgName);
		
		UtilityClassObject.getTest().log(Status.INFO,orgName + "create a new Org");
		   //ListenerIMPclass.test.log(Status.INFO,orgName + "===create a new Org");
		cnop.getSavebtn().click();

		Thread.sleep(2000);
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + "is VERIFIED==pass");
		} else {
			System.out.println(orgName + "is not VERIFIED==fail");
		}
	

		Thread.sleep(2000);
		String actname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actname.equals(orgName)) {
			System.out.println(orgName + "is created==pass");
		} else {
			System.out.println(orgName + "is not created==fail");
		}

	}
	
	
	@Test(groups = {"integration"})
	public void createOrgWithPhonenoTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String orgName = elib.getdatafromExcel("Org", 7, 2) + jlib.getrandomnum();
		String phoneno = elib.getdatafromExcel("Org", 7, 3);

		Homepage hp = new Homepage(driver);
		hp.getOrglink().click();

		Organizationpage op = new Organizationpage(driver);
		op.getCreateorgbtn().click();

		CreateNeworgpage cnop = new CreateNeworgpage(driver);
		cnop.createneworg(orgName);
		cnop.createwithphno(phoneno);
		cnop.getSavebtn().click();

		Thread.sleep(2000);
		String actphone = driver.findElement(By.id("dtlview_Phone")).getText();
		Thread.sleep(1000);
		if (phoneno.equals(actphone)) {
			System.out.println(actphone + "information is verified==pass");
		} else {
			System.out.println(actphone + "information is not verified==fail");
		}

	}
	
	@Test(groups = {"integration"})
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException, InterruptedException {

		String orgName = elib.getdatafromExcel("Org", 7, 2) + jlib.getrandomnum();
		String industry = elib.getdatafromExcel("Org", 4, 3);
		String type = elib.getdatafromExcel("Org", 4, 4);

		Homepage hp = new Homepage(driver);
		hp.getOrglink().click();

		Organizationpage op = new Organizationpage(driver);
		op.getCreateorgbtn().click();

		CreateNeworgpage cnop = new CreateNeworgpage(driver);
		
		Thread.sleep(1000);
		cnop.createneworg(orgName);
		cnop.createorgwithindustry1(industry);
		cnop.createorgwithtype(type);
		
		cnop.getSavebtn().click();

		Thread.sleep(2000);
		String actindustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (industry.equals(actindustry)) {
			System.out.println(industry + "information is verified==pass");
		} else {
			System.out.println(industry + "information is not verified==fail");
		}

		Thread.sleep(2000);
		String acttype = driver.findElement(By.id("dtlview_Type")).getText();
		if (type.equals(acttype)) {
			System.out.println(type + "information is verified==pass");
		} else {
			System.out.println(type + "information is not verified==fail");
		}

	}
}
