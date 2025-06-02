package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {

	WebDriver driver;
	public Organizationpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorgbtn;

	public WebElement getCreateorgbtn() {
		return createorgbtn;
	}
	
	
}
