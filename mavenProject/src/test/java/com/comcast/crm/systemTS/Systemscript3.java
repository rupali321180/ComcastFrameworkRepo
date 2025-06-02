package com.comcast.crm.systemTS;

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
import com.concast.com.generic.webdriverutility.Webdriverutility;


/**
 * test class for CRM organization module
 * @author Rupali
 */




public class Systemscript3 {

	public static void main(String[] args) throws Throwable, InterruptedException {
		// TODO Auto-generated method stub

		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		Webdriverutility wlib=new Webdriverutility();
		
		String	Browser = flib.getdatafromPropertiesfile("browser");
		String URL=flib.getdatafromPropertiesfile("url");
		String UN=flib.getdatafromPropertiesfile("username");
		String PSW=flib.getdatafromPropertiesfile("password");
		
		String orgName = elib.getdatafromExcel("SCENARIO", 16,2)+jlib.getrandomnum();
		String documentname=elib.getdatafromExcel("SCENARIO",16,3);
		String dfoldername=elib.getdatafromExcel("SCENARIO",16,4);
		String dassign=elib.getdatafromExcel("SCENARIO",16,5);
		

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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Documents'])[1]")).click();
		 driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
		 driver.findElement(By.name("notes_title")).sendKeys(documentname);
		 
		 Thread.sleep(2000);
		 WebElement ddown = driver.findElement(By.name("folderid"));
		 Select s=new Select(ddown);
		 s.selectByVisibleText(dfoldername);
		 
		 Thread.sleep(2000);
		  driver.findElement(By.name("assigntype")).click();
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
			Thread.sleep(2000);
			String actDname=driver.findElement(By.id("dtlview_Title")).getText();
			if(documentname.equals(actDname))
			{
				System.out.println(documentname + "is created==pass");
			}
			else {
				System.out.println(documentname + "is not created==fail");
			}
			
			
			driver.quit();
		
		
		
		
		
		
	}

}
