package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;
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
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.loginpage;
import com.comcast.crm.listenerutility.UtilityClassObject;
import com.concast.com.generic.fileutility.ExcelUtility;
import com.concast.com.generic.fileutility.Fileutility;
import com.concast.com.generic.webdriverutility.Javautility;
import com.concast.com.genericdatabaseutility.Databaseutility;



public class Baseclass {

	
	
	public WebDriver driver = null;  //object
	public static WebDriver sdriver = null;     //– This means the variable belongs to the class itself,
	public ExcelUtility elib = new ExcelUtility();    //To make the WebDriver globally available across the project,
	public Fileutility flib = new Fileutility();
	public Databaseutility dlib = new Databaseutility();
	public Javautility jlib = new Javautility();

	@BeforeSuite(groups = {"smoke","regression"})
	public void configBS() throws SQLException {
		System.out.println("===connect to DB , Report config===");
		dlib.getdbconnection();
	}

	@BeforeClass(groups = {"smoke","regression"})
	public void BC() throws IOException {
		System.out.println("lunch the browser");
		String Browser=System.getProperty("browser" , flib.getdatafromPropertiesfile("browser"));
		//String Browser = flib.getdatafromPropertiesfile("browser");

		if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}
     //  sdriver = driver;
       //UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void configBM() throws IOException, Throwable {
		System.out.println("==login==");
		//String URL = flib.getdatafromPropertiesfile("url");
		//String USERNAME = flib.getdatafromPropertiesfile("username");
		//String PASSWORD = flib.getdatafromPropertiesfile("password");
		String URL=System.getProperty("url" , flib.getdatafromPropertiesfile("url"));
		String USERNAME=System.getProperty("username" , flib.getdatafromPropertiesfile("username"));
		String PASSWORD=System.getProperty("password" , flib.getdatafromPropertiesfile("password"));
		
		loginpage lp = new loginpage(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		lp.logintoapp(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = {"smoke","regression"})
	public void configAM() throws InterruptedException {
	System.out.println("==logout==");

	Homepage hp = new Homepage(driver);
	hp.logout();
	}

	@AfterClass(groups = { "smoke", "regression"})
	public void configAC() {
		System.out.println("==close the browser==");
    	driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression"})
	public void configAS() {
		System.out.println("===close DB , report backup===");
		dlib.closeconnection();
	}

}
