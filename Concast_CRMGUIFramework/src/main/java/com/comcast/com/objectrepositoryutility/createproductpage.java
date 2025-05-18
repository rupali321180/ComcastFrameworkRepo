package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createproductpage {


	WebDriver driver;
	public createproductpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "productname")
	private WebElement producttxtfield;
	
	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement savebtn;

	
	public WebElement getProducttxtfield() {
		return producttxtfield;
	}
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}


	public void createProduct(String productname)
	{
		producttxtfield.sendKeys(productname);
	}
	
}
