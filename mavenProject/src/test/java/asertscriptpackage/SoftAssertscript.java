package asertscriptpackage;

import java.lang.reflect.Method;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.comcast.crm.basetest.Baseclass;

/**
 * test class for softAssert
 * @author Rupali
 */



public class SoftAssertscript extends Baseclass{
   @Test
	public void homepagetest(Method mtd) {
		Reporter.log(mtd.getName() + "Teststart");
		SoftAssert assertobj=new SoftAssert();
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		assertobj.assertEquals("Home","Home");
		Reporter.log("step-4",true);
		assertobj.assertEquals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM", "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRMm");
	   Reporter.log("step-5",true);
	   assertobj.assertAll();
	   Reporter.log(mtd.getName() + "Testend");
	}
}
