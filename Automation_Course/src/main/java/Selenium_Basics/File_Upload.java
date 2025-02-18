package Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class File_Upload {
 public void fileuploadingusingsendkeys() {
	 WebDriver driver=new ChromeDriver();
	 
	 driver.navigate().to("https://demo.guru99.com/selenium/upload/");
	 WebElement choosefile=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
	 choosefile.sendKeys("C:\\Users\\GOPIKA\\Desktop\\GOPIKA CV.pdf");
 }
 public void fileuploadusingrobotkey()throws AWTException{
	 WebDriver driver=new ChromeDriver();
	 driver.navigate().to("https://demo.guru99.com/selenium/upload/");
	 WebElement choosefile=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
	 Actions actions=new Actions(driver);
	 actions.moveToElement(choosefile).click().perform();
	 StringSelection ss = new StringSelection("C:\\Users\\GOPIKA\\Desktop\\GOPIKA CV.pdf");
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	 Robot robot=new Robot();
	 robot.delay(500);
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 robot.delay(500);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_V);
	 robot.delay(500);
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
 }
	public static void main(String[] args) throws AWTException {
		File_Upload fileupload=new File_Upload();
		fileupload.fileuploadingusingsendkeys();
		fileupload.fileuploadusingrobotkey();
		//fileupload.driverQuit();
	}

}
