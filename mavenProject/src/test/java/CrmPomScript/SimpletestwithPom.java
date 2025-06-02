package CrmPomScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * test class for CRM organization module
 * @author Rupali
 */



public class SimpletestwithPom {

	@FindBy(name="user_name")
	 WebElement usernameedit;
	
	@FindBy(name="user_password")
	 WebElement passworedit;
	
	@FindAll({@FindBy(id= "submitButton"), @FindBy(xpath = "//input[@type='su']")})
	 WebElement loginbtn;
	
	
	@Test
	public void sampletest() throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://49.249.28.218:8888");
		
		SimpletestwithPom sam= PageFactory.initElements(driver,SimpletestwithPom.class);
		sam.usernameedit.sendKeys("admin");
		sam.passworedit.sendKeys("admin");
		Thread.sleep(2000);
		sam.loginbtn.click();
		driver.close();
	}
	
	
	
	
	
	
	
	
	
}
