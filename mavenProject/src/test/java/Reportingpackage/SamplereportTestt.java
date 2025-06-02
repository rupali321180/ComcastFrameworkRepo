 package Reportingpackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * test class for extent report
 * @author Rupali
 */



public class SamplereportTestt {

	ExtentReports report;
	//TO reduce again doing programming
	
		@BeforeSuite
		public void config() {
			ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport2/report.html");
			spark.config().setDocumentTitle("CRM test suite results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add Env information and create test
			report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS","Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");
			
		}
		
		@AfterSuite
		public void configAS() {
			System.out.println("clean flush");
			report.flush();
		}
		
		@Test
		public void createContactTest() {
			ExtentTest test=report.createTest("createContactTest");
			
			test.log(Status.INFO,"login to app");
			test.log(Status.INFO,"navigate to contact page");
			test.log(Status.INFO,"create contact");
			
			if("HDFC".equals("HDFC"))
				{
				test.log(Status.PASS,"contact is created");
				}else {
				test.log(Status.FAIL,"contact is not created");
			}
			
		
		}
		
		@Test
		public void createORGTest() {
			ExtentTest test=report.createTest("createORGTest");
			
			test.log(Status.INFO,"login to app");
			test.log(Status.INFO,"navigate to contact page");
			test.log(Status.INFO,"create contact");
			
			if("HDFC".equals("HDFC"))
				{
				test.log(Status.PASS,"contact is created");
				}else {
				test.log(Status.FAIL,"contact is not created");
			}
		}
			
		@Test
		public void createContactTestt() {
			
			WebDriver driver=new ChromeDriver();
			driver.get("http://49.249.28.218:8888/index.php");
			
			TakesScreenshot edriver=(TakesScreenshot)driver;
			String filepath=edriver.getScreenshotAs(OutputType.BASE64);
			ExtentTest test=report.createTest("createContactTestt");
			
			test.log(Status.INFO,"login to app");
			test.log(Status.INFO,"navigate to contact page");
			test.log(Status.INFO,"create contact");
			
			if("HDFCC".equals("HDFC"))
				{
				test.log(Status.PASS,"contact is created");
				}else {
				test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
			}
		driver.close();
		}		
}
