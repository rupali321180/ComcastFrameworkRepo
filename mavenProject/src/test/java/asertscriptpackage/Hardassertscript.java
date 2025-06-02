package asertscriptpackage;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.Baseclass;

/**
 * test class hard assert
 * @author Rupali
 */

public class Hardassertscript extends Baseclass {

	@Test
public void homepagetest(Method mtd) {
		Reporter.log(mtd.getName() + "Teststart");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Assert.assertEquals("Home","Home");
		Reporter.log("step-4",true);
		Assert.assertEquals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM", "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRMm");
	   Reporter.log("step-5",true);
	   Reporter.log(mtd.getName() + "Testend");
	}
	
	@Test
	public void verifylogoHomepageTest(Method mtd) {
		Reporter.log(mtd.getName() + "Teststart");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
	Assert.assertTrue(false);
	//	I expect true → got true
	//	I expect true → got false
	
	Reporter.log("step-4",true);
	Reporter.log("step-5",true);
	Reporter.log(mtd.getName() + "TestEnd");
		
		
	}		
}
