package com.comcast.crm.orgtest;


import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import com.comcast.com.objectrepositoryutility.CreateNeworgpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.Organizationpage;
import com.comcast.crm.basetest.Baseclass;

/**
 * test class for organization module
 * @author Rupali
 */




 //@Listeners(com.comcast.crm.listenerutility.ListenerIMPclass.class)
@Test
public class Createorgtest extends Baseclass {
	
	
	
	@Test(groups = {"smoke","regression"})
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
	
	@Test(groups = {"smoke","regression"})
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
