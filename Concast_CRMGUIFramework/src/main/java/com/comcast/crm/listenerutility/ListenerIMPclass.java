package com.comcast.crm.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.Baseclass;


public class ListenerIMPclass implements ITestListener , ISuiteListener {
	
	ExtentReports report;
	//ExtentTest test;
	public static ExtentTest test;
   @Override
   //this runs before the entire test suite start
   
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		  String time=new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport2/report1."+time+".html");
		//ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport2/report1.html");
		spark.config().setDocumentTitle("CRM test suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
   //this runs before the entire test suite ends
   
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
		
	}
	@Override
	public void onTestStart(ITestResult result) {  //before each test method starts
		// TODO Auto-generated method stub
		System.out.println("===== ===>"+result.getMethod().getMethodName()+">======START=====");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+"===STARTED===");
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {   //this run when a test passes
		// TODO Auto-generated method stub
		System.out.println("===== ===>"+result.getMethod().getMethodName()+">======END=====");
		 test.log(Status.PASS,result.getMethod().getMethodName()+"===COMPLETED===");
		 UtilityClassObject.getTest().log(Status.PASS, "Test passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {   //this runs when a test failss
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	    String testName = result.getMethod().getMethodName();
	    TakesScreenshot ts=(TakesScreenshot)Baseclass.sdriver;
	    String filepath=ts.getScreenshotAs(OutputType.BASE64);
	    
	    //File temp=ts.getScreenshotAs(OutputType.FILE);
	    String time=new Date().toString().replace(" ","_").replace(":","_");
	    test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
	    test.log(Status.FAIL,result.getMethod().getMethodName()+"===FAILED===");
	    UtilityClassObject.getTest().log(Status.FAIL, "Test passed");
	  }
	  
    
	
    
	}
	
	   // try {
	  //  FileUtils.copyFile(temp,new File("./Screenshot1/"+testName+ "+"+time+".png"));
	   // }
	   // catch(IOException e) {
	    //	e.printStackTrace();
	  
