package pracscript;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.concast.com.generic.fileutility.ExcelUtility;
import com.concast.com.generic.fileutility.Fileutility;
import com.concast.com.generic.webdriverutility.Javautility;


public class CreatecontactWithOrgTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		
	String	Browser = flib.getdatafromPropertiesfile("browser");
	String URL=flib.getdatafromPropertiesfile("url");
	String UN=flib.getdatafromPropertiesfile("username");
	String PSW=flib.getdatafromPropertiesfile("password");
	
	//GENERATE THE RANDOM NUMBER
	
	
	//read testscript data from excel file
	
	String orgName=elib.getdatafromExcel("contact" , 7, 2)+ jlib.getrandomnum();
	String contactLastname=elib.getdatafromExcel("contact" , 7, 3);
	
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

	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	
	
	Thread.sleep(2000);
	//verify header msg expected result
	String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(orgName))
	{
		System.out.println(orgName + "is created==pass");
	}
	else {
		System.out.println(orgName + "is not created");
	}
	//step5-NAVIGATE TO CONTACT MODULE
	
	driver.findElement(By.linkText("Contacts")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(contactLastname);
	
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
	//switch to child window
	
	 String pid = driver.getWindowHandle();
	 Set<String> allwh = driver.getWindowHandles();
	 
	 for(String we:allwh)
	 {
		 driver.switchTo().window(we);
		 System.out.println(driver.getTitle());
	 }
	 
	 
	Thread.sleep(2000);
	driver.findElement(By.name("search_text")).sendKeys(orgName,Keys.ENTER);
	Thread.sleep(2000);
	
	Thread.sleep(2000);
    driver.findElement(By.xpath("//a[text()='"+ orgName +"']")).click();

	
	//dynamic xpath for switching to the parent window
      //switch to parent window
	
	Iterator<String> it1 = allwh.iterator();
	while(it1.hasNext())
	{
		String windowid = it1.next();
		driver.switchTo().window(windowid);
		String actlurl = driver.getCurrentUrl();
		if(actlurl.contains("Contacts&action"))
		{
			break;
		}
	}
	
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	Thread.sleep(2000);
	 headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(contactLastname))
	{
		System.out.println(contactLastname + "is created==pass");
	}
	else {
		System.out.println(contactLastname + "is not created");
	}
	//verify header orgname info expected result
	
	Thread.sleep(2000);
	String actname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(actname);
	
	if(actname.trim().equals(orgName))
	{
		System.out.println(orgName + "is created==pass");
	}
	else {
		System.out.println(orgName + "is not created");
	}
	
	driver.quit();
	}

}
