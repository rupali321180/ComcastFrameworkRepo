package asertscriptpackage;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.Baseclass;

public class InvoiceTESTT extends Baseclass {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateTest() {
		System.out.println("execute createinvoice test");
		String actTitle=driver.getTitle();
		//Assert.assertEquals(actTitle,"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRMm");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
}
}