package com.comcast.crm.systemTS;

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

public class NavigatingtoProductmodule {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		Webdriverutility wlib=new Webdriverutility();
		
		String	Browser = flib.getdatafromPropertiesfile("browser");
		String URL=flib.getdatafromPropertiesfile("url");
		String UN=flib.getdatafromPropertiesfile("username");
		String PSW=flib.getdatafromPropertiesfile("password");
		
		String orgName = elib.getdatafromExcel("SCENARIO", 7, 2)+jlib.getrandomnum();
		String contactlastname=elib.getdatafromExcel("SCENARIO",7,3);
		String productname=elib.getdatafromExcel("SCENARIO",7,4);
		
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
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);

		 driver.findElement(By.linkText("Contacts")).click();
	
	
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
		
		driver.findElement(By.name("lastname")).sendKeys(contactlastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actlastname.equals(contactlastname))
		{
			System.out.println(contactlastname + "information is verified==pass");
		}
		else {
			System.out.println(contactlastname + "information is not verified");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		String actproductname=driver.findElement(By.id("dtlview_Product Name")).getText();
		if(actproductname.equals(productname))
		{
			System.out.println(productname +"is created==pass");
		}
		else {
			System.out.println(productname +"is not created==faill");
		}
		
		driver.quit();
		
		
	}

}
