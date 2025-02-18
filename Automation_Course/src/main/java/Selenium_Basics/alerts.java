package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class alerts extends Base
{
public void alerts1()
{
	driver.navigate().to("https://selenium.qabible.in/javascript-alert.php");
	WebElement clickme1=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	clickme1.click();
	driver.switchTo().alert().accept();
	
	WebElement clickme2=driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
	clickme2.click();
	driver.switchTo().alert().dismiss();
	
	WebElement clickme3=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	clickme3.click();
	driver.switchTo().alert().sendKeys("Warnning");
	String alerttext=driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	System.out.println(alerttext);
	
	WebElement message=driver.findElement(By.xpath("//p[@id='prompt-demo']"));
	System.out.println(message.getText());
}

	public static void main(String[] args) {
		alerts alert=new alerts();
		alert.initialiseBrowser();
		alert.alerts1();
	}

}
