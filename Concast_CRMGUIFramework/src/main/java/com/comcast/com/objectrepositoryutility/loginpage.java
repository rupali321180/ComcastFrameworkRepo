package com.comcast.com.objectrepositoryutility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concast.com.generic.webdriverutility.Webdriverutility;


public class loginpage extends Webdriverutility{

	//object initialization
		WebDriver driver;
		public loginpage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver,this);
		}

		//object creation
		
		@FindBy(xpath ="//input[@type='text']")
		private WebElement usernameedit;
		
		@FindBy(name="user_password")
		private WebElement passworedit;
		
		@FindBy(id="submitButton")
		private WebElement loginbtn;
		
		//object encapsulation
		public WebElement getusernameedit() {
			return usernameedit;
		}
		public WebElement getpassworedit() {
			return passworedit;
		}
		
		public WebElement getloginbtn() {
			return loginbtn;
		}
		
		//provide action
		           //business method
		public void logintoapp(String username ,String password) {
			usernameedit.sendKeys(username);
			passworedit.sendKeys(password);
			loginbtn.click();
			
			
			
			
		}
		
	}



	
