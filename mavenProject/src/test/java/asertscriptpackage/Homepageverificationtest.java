package asertscriptpackage;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * test class CRM Home page
 * @author Rupali
 */



public class Homepageverificationtest {

	@Test
	
	public void homepagetest(Method mtd) {        //we write method class to capture the name of the method dynamically
		
		System.out.println(mtd.getName() + "Test Start");
		String expectedpage="Homepage";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actTitle = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		
		//Hard Assert
		Assert.assertEquals(actTitle, expectedpage);
		
		driver.close();
		
		System.out.println(mtd.getName() + "Test End");
		
	}
	
	@Test
	public void verifyLogoHomepageTest(Method mtd) {
		System.out.println(mtd.getName() + "Test Start");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		//Hard Assert
		//Assert.assertTrue(true,status);
		
	    Assert.assertTrue(status);
		driver.close();
		
		System.out.println(mtd.getName() + "Test End");
	}
}
