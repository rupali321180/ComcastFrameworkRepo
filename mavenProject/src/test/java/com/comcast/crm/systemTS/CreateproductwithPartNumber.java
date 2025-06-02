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

/**
 * test class for CRM organization module
 * @author Rupali
 */




public class CreateproductwithPartNumber {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		Webdriverutility wlib=new Webdriverutility();
		
		String	Browser = flib.getdatafromPropertiesfile("browser");
		String URL=flib.getdatafromPropertiesfile("url");
		String UN=flib.getdatafromPropertiesfile("username");
		String PSW=flib.getdatafromPropertiesfile("password");
		
		String productName=elib.getdatafromExcel("SCENARIO",4,2)+ jlib.getrandomnum();
		String partnumber = elib.getdatafromExcel("SCENARIO", 4, 3);
		
		
		
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
		wlib.waitforpagetoload(driver);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		
		driver.findElement(By.name("productcode")).sendKeys(partnumber);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		String headerinfo=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(headerinfo.contains(productName))
		{
			System.out.println(productName + "product is created");
		}
		else {
			System.out.println(productName + "product is not created");
		}
		
		
		String actpartnum=driver.findElement(By.id("dtlview_Part Number")).getText();
		if(partnumber.equals(actpartnum))
		{
			System.out.println(actpartnum + "is created==pass");
		}
		else {
			System.out.println(actpartnum + "is not created==fail");
		}
		driver.quit();
		
	}

}
