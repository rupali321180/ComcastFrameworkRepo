package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class oppertunitypage {

	WebDriver driver;
	public oppertunitypage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createoppertunitybtn;

	public WebElement getCreateoppertunitybtn() {
		return createoppertunitybtn;
	}
	
	
}
