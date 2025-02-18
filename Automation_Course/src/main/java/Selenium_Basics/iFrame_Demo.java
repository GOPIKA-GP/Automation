package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrame_Demo  {
	
	public WebDriver driver;
	public void initialiseBrowser() 
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
	}
	public void driverQuit()
	{
		driver.quit();
	}
	public void iframe_hw() {
		WebElement frame1=driver.findElement(By.xpath("//iframe[@name='a077aa5e']"));
		driver.switchTo().frame(frame1);
		
		WebElement heading=driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		heading.click();
		
		driver.switchTo().parentFrame();
	}

	public static void main(String[] args) {
		iFrame_Demo frames=new iFrame_Demo();
		frames.initialiseBrowser();
		frames.iframe_hw();
		//frames.driverQuit();
	

	}

}
