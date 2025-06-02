package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildOrgPage {

	WebDriver driver;
	public ChildOrgPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "search_txt")
   private WebElement searchfield;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public void searchTest(String value)
	{
		searchfield.sendKeys(value);
		searchbtn.click();
	}
	
	
	
	
	
	
}
