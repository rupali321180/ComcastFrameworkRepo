package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewoppertunitypage {


	WebDriver driver;
	public Createnewoppertunitypage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "potentialname")
	private WebElement oppertunitytxtfield;
	
	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement selectbtn;
	
	@FindBy(name = "search_text")
	private WebElement txtfield;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;

	public WebElement getOppertunitytxtfield() {
		return oppertunitytxtfield;
	}
	
	public WebElement getSelectbtn() {
		return selectbtn;
	}
	
	public WebElement getTxtfield() {
		return txtfield;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	

	public void getoppertunity(String oppertunityname) throws InterruptedException
	{
		oppertunitytxtfield.sendKeys(oppertunityname);
		selectbtn.click();
		
		Thread.sleep(2000);
		txtfield.sendKeys(oppertunityname,Keys.ENTER);
		savebtn.click();
	}
	
	
}
