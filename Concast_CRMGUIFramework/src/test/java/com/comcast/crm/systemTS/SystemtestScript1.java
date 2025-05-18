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

public class SystemtestScript1 {

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
		
		String orgName = elib.getdatafromExcel("SCENARIO", 13,2)+jlib.getrandomnum();
		String contactlastname=elib.getdatafromExcel("SCENARIO",13,3);
		String productname=elib.getdatafromExcel("SCENARIO",13,4);
		String vendorpartno=elib.getdatafromExcel("SCENARIO",13,5);
		String Psheetno=elib.getdatafromExcel("SCENARIO",13,6);
		String Ppartno=elib.getdatafromExcel("SCENARIO",13,7);
		String Pserialno=elib.getdatafromExcel("SCENARIO",13,8);
		
		

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
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		
		driver.findElement(By.name("vendor_part_no")).sendKeys(vendorpartno);
		driver.findElement(By.name("productsheet")).sendKeys(Psheetno);
		driver.findElement(By.id("productcode")).sendKeys(Ppartno);
		driver.findElement(By.name("serial_no")).sendKeys(Pserialno);
		
		
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		 String actPDname=driver.findElement(By.id("dtlview_Product Name")).getText();
		 if(actPDname.equals(productname))
			{
				System.out.println(productname + "is created==pass");
			}
			else {
				System.out.println(productname + "is not created");
			}
		 String actVENpartno=driver.findElement(By.id("dtlview_Vendor Part No")).getText();
		 if(actVENpartno.equals(vendorpartno))
		 {
			 System.out.println(vendorpartno + "is created==pass");
		 }
		 else {
			 System.out.println(vendorpartno + "is not created==fail");
		 }
		 
		 String actPsheetno=driver.findElement(By.id("dtlview_Product Sheet")).getText();
		 if(actPsheetno.equals(Psheetno))
		 {
			 System.out.println(Psheetno + "is created==pass");
		 }
		 else {
			 System.out.println(Psheetno + "is not created==fail");
		 }
		 
		 String actPpartno=driver.findElement(By.id("dtlview_Part Number")).getText();
		 if(actPpartno.equals(Ppartno))
		 {
			 System.out.println(Ppartno + "is created==pass");
		 }
		 else {
			 System.out.println(Ppartno + "is not created==fail");
		 }
		 
		 String actPserialno=driver.findElement(By.id("dtlview_Serial No")).getText();
		 if(actPserialno.contains(Pserialno))
		 {
			 System.out.println(Pserialno + "is created==pass");
		 }
		 else {
			 System.out.println(Pserialno + "is not created==fail");
		 }
		 
		 
		 driver.quit();
		
		
		
		
	}

}
