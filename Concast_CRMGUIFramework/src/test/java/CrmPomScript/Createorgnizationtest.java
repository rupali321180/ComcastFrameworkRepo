package CrmPomScript;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.com.objectrepositoryutility.CreateNeworgpage;
import com.comcast.com.objectrepositoryutility.Homepage;
import com.comcast.com.objectrepositoryutility.OrgInfopage;
import com.comcast.com.objectrepositoryutility.Organizationpage;
import com.comcast.com.objectrepositoryutility.loginpage;
import com.concast.com.generic.fileutility.ExcelUtility;
import com.concast.com.generic.fileutility.Fileutility;
import com.concast.com.generic.webdriverutility.Javautility;
import com.concast.com.generic.webdriverutility.Webdriverutility;

public class Createorgnizationtest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
        String username="admin";
		String password="admin";
		
		
		
		//create object
		Fileutility flib=new Fileutility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		Webdriverutility wlib=new Webdriverutility();
		
	//read common data fromjson file	
	String	Browser = flib.getdatafromPropertiesfile("browser");
	String URL= flib.getdatafromPropertiesfile("url");
	String UN= flib.getdatafromPropertiesfile("username");
	String PSW= flib.getdatafromPropertiesfile("password");
	
	//GENERATE THE RANDOM NUMBER
	
	//read testscript data from excel file
	String orgName=elib.getdatafromExcel("Org",10, 2)+ jlib.getrandomnum();
	String industryname=elib.getdatafromExcel("Org",4,3);
	
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
	driver.manage().window().maximize();
	loginpage lp=new loginpage(driver);
	lp.logintoapp(username, password);;
	
    Homepage hp=new Homepage(driver);
    hp.getOrglink().click();
    
    Organizationpage oop=new Organizationpage(driver);
    oop.getCreateorgbtn().click();
    
    CreateNeworgpage cno=new CreateNeworgpage(driver);
    cno.createneworg(orgName);;
    
    Thread.sleep(2000);
    OrgInfopage oipg=new OrgInfopage(driver);
    String headerinfo = oipg.getHeadermsgtxt().getText();
    
    if(headerinfo.contains(orgName))
    {
    	System.out.println(orgName+" is verified");
    }
    else {
    	System.out.println(orgName +"is not verified");
    }
    
  String  actlname= oipg.getDtlview().getText();
  if(actlname.equals(orgName))
  {
	  System.out.println("orgName is created==pass");
  }
  else {
	  System.out.println("orgName is not created==fail");
  }
    
     driver.quit();
	
	
}

}
