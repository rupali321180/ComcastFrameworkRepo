package asertscriptpackage;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.comcast.com.objectrepositoryutility.Createnewcontactpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.contactpage;
import com.comcast.crm.basetest.Baseclass;

/**
 * selenium test class
 * @author Rupali
 */



public class verifywithRealseleniumTest extends Baseclass {

	
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
			
			String actheader = cp.getHeadermsg().getText();
			boolean status = actheader.contains(lastname);
			Assert.assertEquals(status,true);
	        
			Thread.sleep(2000);
			String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
			SoftAssert assertobj=new SoftAssert();
			assertobj.assertEquals(actlastname, lastname);
			assertobj.assertAll();
		}
}
