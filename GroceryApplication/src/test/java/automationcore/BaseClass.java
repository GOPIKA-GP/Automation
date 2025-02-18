package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenShotUtility;

public class BaseClass{
	Properties prop;
	FileInputStream fs;
	
public WebDriver driver;

@BeforeMethod(alwaysRun=true)
@Parameters("browser")
public void initialiseBrowser(String browser) throws Exception {
	 prop=new Properties();
	 fs=new FileInputStream(Constant.CONFIGFILE);
	 prop.load(fs);
	 if(browser.equalsIgnoreCase("Chrome"))
	 {
		 driver=new ChromeDriver(); 
	 }
	 else if(browser.equalsIgnoreCase("Edge"))
	 {
		 driver=new EdgeDriver(); 
	 }
	 else
	 {
		 throw new Exception("Invalid Browser");
	 }
	  driver.get(prop.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
}

@AfterMethod(alwaysRun=true)
public void driverQuit(ITestResult itestresult) throws IOException 
{
	if(itestresult.getStatus()==ITestResult.FAILURE)
	
		{
				ScreenShotUtility screenshot=new ScreenShotUtility();
				screenshot.captureFailureScreenShot(driver,itestresult.getName());
		}
}
//driver.close();
}
