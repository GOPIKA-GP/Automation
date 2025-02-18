package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Iframe extends Base {
	public void iframes() {
		driver.navigate().to("https://demoqa.com/frames");
		
		//Step 1: Switch to frame
		
		//driver.switchTo().frame("frame1");
		WebElement iframeElement=driver.findElement(By.xpath("//iframe[@id='frame1']"));//or using webelement
		driver.switchTo().frame(iframeElement);// use any one of the above
		
		//Step2: Perform action
		
		WebElement frameheading=driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
		System.out.println(frameheading.getText());
		
		//step3:Back to main frame
		
		driver.switchTo().parentFrame();
		//driver.switchTo().defaultContent();//use any of the one
		
	}

	public static void main(String[] args) {
		Iframe iframe=new Iframe();
		iframe.initialiseBrowser();
		iframe.iframes();
		//iframe.driverQuit();
		
	}

}
