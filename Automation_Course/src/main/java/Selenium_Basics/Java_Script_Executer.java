package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Java_Script_Executer extends Base {
	public void sample() {
		JavascriptExecutor executer=(JavascriptExecutor)driver;
		executer.executeScript("window.scrollBy(0,350)","");//x=0,y=350  up
		executer.executeScript("window.scrollBy(0,-350)","");//down
		WebElement showmessagebutton=driver.findElement(By.xpath("//button[text()='Show Message']"));//click
		executer.executeScript("arguments[0].click;", showmessagebutton);
		
		WebElement gettotalbutton=driver.findElement(By.xpath("//button[@id='button-two']"));;
		executer.executeScript("arguments[0].click;",gettotalbutton);
		executer.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		executer.executeScript("arguments[0].scrollIntoView()", gettotalbutton);
		
		driver.navigate().to("https://www.javatpoint.com/");
		executer.executeScript("window.scrollBy(500,0)","");//right
		executer.executeScript("window.scrollBy(-500,0)","");//left
		
		
	}

	public static void main(String[] args) {
		Java_Script_Executer jexecutor=new Java_Script_Executer();
		jexecutor.initialiseBrowser();
		jexecutor.sample();
		//jexecutor.driverQuit();
		

	}

}
