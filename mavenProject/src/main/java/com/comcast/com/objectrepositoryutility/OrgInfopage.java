package com.comcast.com.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfopage {

	WebDriver driver;
	public OrgInfopage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "/html/body/table[3]/tbody/tr[1]/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")
	private WebElement headermsgtxt;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement dtlview;
	
	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement industryddn;

	public WebElement getHeadermsgtxt() {
		return headermsgtxt;
	}

	public WebElement getIndustryddn() {
		return industryddn;
	}

	public WebElement getDtlview() {
		return dtlview;
	}
	
	
	
	
	
	
}
