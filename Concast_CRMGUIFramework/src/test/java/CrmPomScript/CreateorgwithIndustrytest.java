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

public class CreateorgwithIndustrytest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		 String username="admin";
			String password="admin";
			
			Fileutility flib=new Fileutility();
			ExcelUtility elib=new ExcelUtility();
			Javautility jlib=new Javautility();
			Webdriverutility wlib=new Webdriverutility();
			
			String	Browser = flib.getdatafromPropertiesfile("browser");
			String URL= flib.getdatafromPropertiesfile("url");
			String UN= flib.getdatafromPropertiesfile("username");
			String PSW= flib.getdatafromPropertiesfile("password");
			
			String orgName=elib.getdatafromExcel("Org",4, 2)+ jlib.getrandomnum();
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
			lp.logintoapp(UN, PSW);
			
		    Homepage hp=new Homepage(driver);
		    hp.getOrglink().click();
		    
		    Organizationpage oop=new Organizationpage(driver);
		    oop.getCreateorgbtn().click();
		    
		    CreateNeworgpage cno=new CreateNeworgpage(driver);
		    cno.createneworg(orgName);
		    cno.createorgwithindustry1(industryname);
		    
		    Thread.sleep(2000);
		    OrgInfopage oipg=new OrgInfopage(driver);
		    String actlname = oipg.getIndustryddn().getText();
		    
		    if(actlname.contains(industryname))
		    {
		    	System.out.println("industry name is verified");
		    }
		    
		    driver.quit();
		    
	}
}
