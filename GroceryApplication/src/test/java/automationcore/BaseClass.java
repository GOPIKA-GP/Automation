package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class BaseClass {
	Properties prop;
	FileInputStream fs;

	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception {
		prop = new Properties();// Create a Properties object to read configuration settings
		fs = new FileInputStream(Constant.CONFIGFILE); // Create a FileInputStream object to read the config file
		prop.load(fs);// Load the properties from the config file
		if (browser.equalsIgnoreCase("Chrome")) // Check if the browser passed as parameter is "Chrome"
		{
			driver = new ChromeDriver(); // Initialize a new ChromeDriver instance for the Chrome browser
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser");// If browser is neither Chrome nor Edge, throw an exception
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		waitutility.implicitWait(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE)

		{
			ScreenShotUtility screenshot = new ScreenShotUtility();
			screenshot.captureFailureScreenShot(driver, itestresult.getName());
		}
		driver.quit();
	}

}