package Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Demo 
{

		public WebDriver driver;
		public void initialiseBrowser() 
		{
			driver=new FirefoxDriver();
			driver.get("https://www.amazon.in");
			driver.manage().window().maximize();
			driver.manage().window().minimize();
		}
		
		public static void main(String[] args) 
		{
			Base_Demo base=new Base_Demo();
			base.initialiseBrowser();
			
		}
}
