package com.comcast.com.objectrepositoryutility;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concast.com.generic.webdriverutility.Webdriverutility;

public class Createnewcontactpage extends Webdriverutility {

	
	WebDriver driver;
	public Createnewcontactpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "accountname")
	private WebElement orgtextfield;
	
	@FindBy(name = "lastname")
	private WebElement lastnametxtfield;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement selectbtn;
	
	//@FindBy(name = "search_text")
	//private WebElement txtfield;
	
	@FindBy(id = "mobile")
	private WebElement phone;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement datef;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement startdate;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement datee;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement enddate;
	
	@FindBy(name = "button")
	private WebElement savebtn;
	
	
	
	
	public WebElement getLastnametxtfield() {
		return lastnametxtfield;
	}
	
	public WebElement getSelectbtn() {
		return selectbtn;
	}
	

	//public WebElement getTxtfield() {
	//	return txtfield;
	//}
	

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getDatef() {
		return datef;
	}
	public WebElement getStartdate() {
		return startdate;
	}
	public WebElement getDatee() {
		return datee;
	}
	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	public void createContactWithName(String lastname) 
	{
		lastnametxtfield.sendKeys(lastname);
	}
	
	 public void createContactWithStartDate(String startdatee) {
	
		datef.clear();
		startdate.sendKeys(startdatee);
}
	
			
	 public void createcontactwithenddate(String enddatee ) throws InterruptedException
		{
		 datee.clear();
		 enddate.sendKeys(enddatee);
		}
	 
	 
	 public void createconwithorg() throws InterruptedException {
		 
		
		switchtotabonurl(driver,"module=Accounts");
			Thread.sleep(2000);
			switchtotabonurl(driver,"module=Contacts");
		  
	}
	 public void createConwithPhone(String phoneno)
	 {
		 phone.sendKeys(phoneno);
	 }
	
}
