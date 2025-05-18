package pracscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.concast.com.generic.fileutility.ExcelUtility;
import com.concast.com.generic.fileutility.Fileutility;
import com.concast.com.generic.webdriverutility.Javautility;

public class CreateorganizationwithIndustry {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		
		
	String	Browser = flib.getdatafromPropertiesfile("browser");
	String URL=flib.getdatafromPropertiesfile("url");
	String UN=flib.getdatafromPropertiesfile("username");
	String PSW=flib.getdatafromPropertiesfile("password");
	
	//GENERATE THE RANDOM NUMBER
	String orgName=elib.getdatafromExcel("Org" , 4, 2)+ jlib.getrandomnum();
	String industry=elib.getdatafromExcel("Org",4 ,3 );
	String type=elib.getdatafromExcel("Org",4 ,4);
	

	
	WebDriver driver=null;
	if(Browser.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if (Browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if (Browser.equals("edge"))
	{
		driver=new EdgeDriver();
		
	}
	else {
		driver=new ChromeDriver();
		
	}
	Thread.sleep(2000);
		
	driver.get(URL);
	
	Thread.sleep(2000);
	driver.findElement(By.name("user_name")).sendKeys("admin");
	
	driver.findElement(By.name("user_password")).sendKeys("admin");
	
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	Thread.sleep(2000);
	WebElement sel = driver.findElement(By.name("industry"));
	Select s=new Select(sel);
	Thread.sleep(2000);
	s.selectByVisibleText(industry);
	
	Thread.sleep(2000);
	WebElement web2 = driver.findElement(By.name("accounttype"));
	Select s1=new Select(web2);
	s1.selectByVisibleText(type);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	//verify the industries and type
	
	Thread.sleep(2000);
	String actindustry = driver.findElement(By.id("dtlview_Industry")).getText();
	if(industry.equals(actindustry))
	{
		System.out.println(industry + "information is verified==pass");
	}
	else {
		System.out.println(industry + "information is not verified==fail");
	}
	
	
	Thread.sleep(2000);
	String acttype=driver.findElement(By.id("dtlview_Type")).getText();
	if(type.equals(acttype))
	{
		System.out.println(type + "information is verified==pass");
	}
	else {
		System.out.println(type + "information is not verified==fail");
	}
	
	
	
	driver.quit();
	


}
}

	

	
