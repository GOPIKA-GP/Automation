package Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
	public WebDriver driver;
	public void initialiseBrowser() 
	{
		driver=new ChromeDriver();  //initializing the ChromeDriver
		driver.get("https://selenium.qabible.in/simple-form-demo.php");//navigating to a webpage
		driver.manage().window().maximize(); //to maximize the window
		driver.manage().window().minimize(); //to minimize the window
	}
	public void driverQuit()
	{
		//driver.quit();//terminate the session completely
		driver.close();//only closes the current browser window.
	}

	public static void main(String[] args) {
		Base base=new Base();
		base.initialiseBrowser();
		base.driverQuit();

	}

}
