package com.concast.com.generic.webdriverutility;


import java.awt.Robot;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {

	public void switchtoframe(WebDriver driver ,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchtoframe(WebDriver driver ,String nameid)
	{
		driver.switchTo().frame(nameid);
	}
	public void switchtoframe(WebDriver driver ,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchtoalertandaccecpt(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchtoalertandcancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	public void selectmtd(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		
	}
	public void mousemoveonElement(WebDriver driver ,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleclick(WebDriver driver ,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void waitforpagetoload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitforelementpresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchtotabonurl(WebDriver driver,String parcialurl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext())
		{
			String windowid=it.next();
			driver.switchTo().window(windowid);
			
			
			String acturl = driver.getCurrentUrl();
			if(acturl.contains(parcialurl))
			{
				break;
			}
		}
	}
	
	public void switchtotabontitle(WebDriver driver,String parcialtitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext())
		{
			String windowid=it.next();
			driver.switchTo().window(windowid);
			
			String acturl = driver.getTitle();
			if(acturl.contains(parcialtitle))
			{
				break;
			}
		}
	}
	
	public void selectbyvalue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}	
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
		
	public void DragAndDropTheElement(WebDriver driver,WebElement element)
	{
		Actions ACT=new Actions(driver);
		ACT.dragAndDrop(element,element).perform();
	}
	
	public void DragAndDropTheElementBy(WebDriver driver,WebElement element,int src,int dst)
	{
		Actions ACT=new Actions(driver);
		ACT.dragAndDropBy(element,src,dst).perform();
	}
	
	public void rightClickTheElement(WebDriver driver,WebElement element)
	{
		Actions ACT=new Actions(driver);
		ACT.contextClick(element).perform();
	}
	
	public void getKeyBoardAction(int keyEvent) 
	{
		try {
		Robot r=new Robot();
		r.keyPress(keyEvent);
		r.delay(500);
		r.keyRelease(keyEvent);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		public void clickElementByJs(WebDriver driver,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
			
			
		}
		
		public void scrollInToView(WebDriver driver,WebElement element)
		{
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollInTOView(true);",element);
			
	}
		public void scrollDownByPixel(WebDriver driver,int pixels)
		{
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,"+ pixels + ")");
			
		}
		public void scrollUpByPixel(WebDriver driver,int pixels)
		{
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,"+ pixels + ")");
			
		}
		public void sendKeysUsingJs(WebDriver driver,WebElement element ,String text)
		{
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='" + text + "';",element);
		}
		public void handleNotificationPopup(WebDriver driver) {
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			 driver=new ChromeDriver(opt);
		
		
}
}
