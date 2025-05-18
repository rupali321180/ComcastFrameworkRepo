package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concast.com.generic.webdriverutility.Webdriverutility;

public class Homepage extends Webdriverutility{

	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement orglink;
	
	@FindBy(xpath = "(//a[text()='Opportunities'])[1]")
	private WebElement opertunitylnk;
	
	@FindBy(xpath = "//a[.='Products']")
	private WebElement productlnk;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactlnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logouticon;
	
	
	@FindBy(linkText = "Sign Out")	
	private WebElement signoutbtn;

	public WebElement getOrglink() {
		return orglink;
	}
	
	public WebElement getOppertunitylnk() {
		return opertunitylnk;
	}
	

	public WebElement getProductlnk() {
		return productlnk;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}

	public WebElement getLogouticon() {
		return logouticon;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	public void logout() throws InterruptedException {
		
		logouticon.click();
		mousemoveonElement(driver, logouticon);
		signoutbtn.click();
		
	}

	
	
	
	
}
