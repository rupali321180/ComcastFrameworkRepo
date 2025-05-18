package pracscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.concast.com.generic.fileutility.ExcelUtility;
import com.concast.com.generic.fileutility.Fileutility;
import com.concast.com.generic.webdriverutility.Javautility;
import com.concast.com.generic.webdriverutility.Webdriverutility;

public class CeateOrgWithPhoneno {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub


		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		Webdriverutility wlib=new Webdriverutility();
		
		String	Browser = flib.getdatafromPropertiesfile("browser");
		String URL=flib.getdatafromPropertiesfile("url");
		String UN=flib.getdatafromPropertiesfile("username");
		String PSW=flib.getdatafromPropertiesfile("password");
		
		
		
		
	//GENERATE THE RANDOM NU
		String orgName=elib.getdatafromExcel("Org" , 7, 2)+ jlib.getrandomnum();
	String phoneno=elib.getdatafromExcel("Org", 7, 3);
	
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
		
	driver.get(URL);
	
	Thread.sleep(2000);
driver.findElement(By.name("user_name")).sendKeys("admin");
	
	driver.findElement(By.name("user_password")).sendKeys("admin");
	
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	driver.findElement(By.id("phone")).sendKeys(phoneno);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	
	
	//verify header phone no info expected result
	Thread.sleep(2000);
	String actphone=driver.findElement(By.id("dtlview_Phone")).getText();
	Thread.sleep(1000);
	if(phoneno.equals(actphone))
	{
		System.out.println(actphone + "information is verified==pass");
	}
	else {
		System.out.println(actphone + "information is not verified==fail");
	}
	
	driver.quit();
	

	}

}
