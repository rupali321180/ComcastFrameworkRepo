package Reportingpackage;


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



public class SamplereportTest {

	@Test
	public void createContactTest() {
		//spark report config
		// Creates an HTML reporter named spark that will generate a report file
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport1/report.html");
		
		// returns a SparkReporterConfig object
		spark.config().setDocumentTitle("CRM test suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information and create test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		ExtentTest test=report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if("HDFC".equals("HDDC"))
			{
			test.log(Status.PASS,"contact is created");
			}else {
			test.log(Status.FAIL,"contact is not created");
		}
		// Finalizes the report and writes all the info into the HTML file.
		report.flush();
		System.out.println("login to app");
	}
}
