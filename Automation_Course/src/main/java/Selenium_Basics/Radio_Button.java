package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Radio_Button extends Base {
	
	public void radiobuttonfunctions() 
	{
		driver.navigate().to("https://selenium.qabible.in/radio-button-demo.php");
		WebElement select1=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		if(!select1.isSelected())
		{
			select1.click();// Select the radio button if it is not selected
		}
		if(select1.isSelected())
		{
			select1.click();// Deselect the radio button if it is selected
		}
		WebElement selectedvalue1=driver.findElement(By.xpath("//button[@id='button-one']"));
		selectedvalue1.click();
		WebElement value=driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(value.getText());
		
		
		
		WebElement select2=driver.findElement(By.xpath("//input[@id='inlineRadio21']"));
		if(!select2.isSelected())
		{
			select2.click();
		}
		if(select2.isSelected())
		{
			select2.click();
		}
		WebElement select3=driver.findElement(By.xpath("//input[@id='inlineRadio23']"));
		{
			select3.click();
		}
		if(select3.isSelected())
		{
			select3.click();
		}
		WebElement selectedvalue2=driver.findElement(By.xpath("//button[@id='button-two']"));
		selectedvalue2.click();
		WebElement value2=driver.findElement(By.xpath("//div[@id='message-two']"));
		System.out.println(value2.getText());
	}

	public static void main(String[] args) {
		Radio_Button radiobutton=new Radio_Button();
		radiobutton.initialiseBrowser();
		radiobutton.radiobuttonfunctions();
		//radiobutton.driverQuit();

	}

}
