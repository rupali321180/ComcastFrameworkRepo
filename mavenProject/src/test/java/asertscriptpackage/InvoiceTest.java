package asertscriptpackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.Baseclass;

/**
 * Assert test class
 * @author Rupali
 */


 //@Listeners(com.comcast.crm.listenerutility.ListenerIMPclass.class)
public class InvoiceTest extends Baseclass{

	@Test
	public void createInvoiceTest() {
		System.out.println("execute createinvoice test");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle,"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRMm");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");

	}
	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createinvoice with contactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
		
		
		
		
	}
}
