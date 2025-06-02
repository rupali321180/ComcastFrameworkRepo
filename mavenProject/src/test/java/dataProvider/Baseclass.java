package dataProvider;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.concast.com.generic.fileutility.Fileutility;
import com.concast.com.genericdatabaseutility.Databaseutility;

/**
 * custom class
 * @author Rupali
 */




public class Baseclass {

	Databaseutility dlib=new Databaseutility();
	Fileutility flib=new Fileutility();
	
	@BeforeSuite //its executing after executing all the classes and only one time
	public void configBS() {
		System.out.println("===connect to DB , Report config===");
		dlib.getdbconnection();
		
	}
	   @BeforeClass
	     public void AC() throws IOException {
		 System.out.println("lunch the browser");
		 String Browser = flib.getdatafromPropertiesfile("browser");
		 
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
}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("==login==");
	}
	@AfterMethod //IT will execute after executing the testcase
	public void configAM() {
		System.out.println("==logout==");
	}
	@AfterClass
	public void configAC() {
		System.out.println("==close the browser==");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("===close DB , report backup===");
	}
	
	
    
}
