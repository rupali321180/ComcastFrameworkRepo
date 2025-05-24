package pracscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.com.objectrepositoryutility.ChildOrgPage;
import com.comcast.com.objectrepositoryutility.Createnewcontactpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.contactpage;
import com.comcast.crm.basetest.Baseclass;
import com.concast.com.generic.webdriverutility.Webdriverutility;

public class Scrript extends Baseclass{

	 @Test
	    public void createContactWithorgTest() throws Throwable {
	        Webdriverutility wlib = new Webdriverutility();

	        String orgName = elib.getdatafromExcel("contact", 7, 2) + jlib.getrandomnum();
	        String contactLastname = elib.getdatafromExcel("contact", 7, 3);

	        Homepage hp = new Homepage(driver);
	        hp.getContactlnk().click();

	        contactpage cp = new contactpage(driver);
	        cp.getCreateconbtn().click();

	        Createnewcontactpage cnop = new Createnewcontactpage(driver);
	        cnop.createContactWithName(contactLastname);

	        // Store the current window handle (Contacts page)
	        String parentWindow = driver.getWindowHandle();

	        cnop.getSelectbtn().click();

	        // Wait and switch to new tab with organization lookup
	        wlib.switchtotabonurl(driver, "module=Accounts&action");

	        ChildOrgPage cop = new ChildOrgPage(driver);
	        cop.getSearchfield().sendKeys(orgName);
	        cop.getSearchbtn().click();

	        wlib.waitforelementpresentt(driver, By.xpath("//a[text()='" + orgName.trim() + "']"), 20);
	        driver.findElement(By.xpath("//a[text()='" + orgName.trim() + "']")).click();

	        // Switch back to parent window using handle
	        driver.switchTo().window(parentWindow);

	        // Wait for the save button to be clickable before continuing
	        wlib.waitforelementpresent(driver, cnop.getSavebtn(), 10);
	        cnop.getSavebtn().click();

	        // Validation
	        String actualLastName = cnop.getActulLastName().getText();
	        wlib.verifyEquals(actualLastName, contactLastname);

	        String actualheadermsg = cnop.getHeadermsg().getText();
	        wlib.verifyEquals(actualheadermsg, contactLastname);
	    }
	}

