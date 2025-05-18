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

public class SystemTestscript4 {

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
		
		String orgName = elib.getdatafromExcel("SCENARIO", 19, 2)+jlib.getrandomnum();

		String orgotheremail=elib.getdatafromExcel("SCENARIO", 19, 4);
		String orgemail=elib.getdatafromExcel("SCENARIO", 19, 5);
		String orgphone=elib.getdatafromExcel("SCENARIO", 19, 6);
		
		
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
		
		
		driver.findElement(By.id("email2")).sendKeys(orgotheremail);
		driver.findElement(By.id("email1")).sendKeys(orgemail);
		driver.findElement(By.id("phone")).sendKeys(orgphone);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		
		String actname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actname.equals(orgName))
		{
			System.out.println(orgName + "is created==pass");
		}
		else {
			System.out.println(orgName + "is not created");
		}
	
		
		
		String actotheremail=driver.findElement(By.id("dtlview_Other Email")).getText();
		
		if(actotheremail.equals(orgotheremail))
		{
			System.out.println(orgotheremail + "is created==pass");
		}
		else {
			System.out.println(orgotheremail + "is not created==fail");
		}
		
		String actorgemail=driver.findElement(By.id("dtlview_Email")).getText();
		if(actorgemail.equals(orgemail))
		{
			System.out.println(orgemail + "is created==pass");
		}
		else {
			System.out.println(orgemail + "is not created==fail");
		}
		
		String actphoneno=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphoneno.equals(orgphone))
		{
			System.out.println(orgphone + "is created==pass");
		}
		else {
			System.out.println(orgphone + "is not created==fail");
		}
		
		
		driver.quit();
		
		
		

	}

}
