package com.comcast.com.objectrepositoryutility;

import java.nio.channels.spi.SelectorProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.concast.com.generic.webdriverutility.Webdriverutility;

public class CreateNeworgpage extends Webdriverutility {

	WebDriver driver;
	public CreateNeworgpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "accountname")
	private WebElement orgtextfield;
	
	@FindBy(id = "phone")
	private WebElement phoneno;
	
	@FindBy(name = "industry")
	private WebElement industrydd;
	
	@FindBy(name = "accounttype")
	private WebElement typedd;
	
	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement savebtn;

	
	
	public WebElement getOrgtextfield() {
		return orgtextfield;
	}

	public WebElement getPhoneno() {
		return phoneno;
	}

	public WebElement getIndustrydd() {
		return industrydd;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createneworg(String orgname) throws InterruptedException {
		Thread.sleep(1000);
		orgtextfield.sendKeys(orgname);
      
	}

	public void createwithphno(String phonenoo) {

		phoneno.sendKeys(phonenoo);

	}

	public void createorgwithindustry1(String industry) {

		industrydd.click();
		selectmtd(industrydd, industry);

	}

	public void createorgwithtype(String type) {

		typedd.click();
		selectmtd(typedd, type);

	}
}
