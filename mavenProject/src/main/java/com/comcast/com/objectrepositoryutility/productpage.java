package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {


	WebDriver driver;
	public productpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createprolnk;
	
	public WebElement getCreateprolnk() {
		return createprolnk;
	}
	
	
	
}
