package Selenium_Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBox extends Base {
	public void checkbox()
	{
	driver.navigate().to("https://selenium.qabible.in/check-box-demo.php"); // navigates to the specified URL
	
	           ///for single checkbox///
	WebElement singlecheckbox=driver.findElement(By.xpath("//input[@class='form-check-input']"));//locates the checkbox element using an XPath locator
	if(!singlecheckbox.isSelected())// if the checkbox is not selected
	{
		singlecheckbox.click();// select the checkbox
	}
	if(singlecheckbox.isSelected())// if the checkbox is selected
	{
		singlecheckbox.click();// deselect the checkbox
	}
	
	
	           ///for multiple checkbox///
	List <WebElement> checkboxes=driver.findElements(By.xpath("//input[@value='Unselect All']")); // Locate the first set of checkboxes and select them if not already selected
	 for(WebElement checkbox:checkboxes)
	{
		if(!checkbox.isSelected())
		{
			checkbox.click();// Select the checkbox if not selected
		}
	}
	 WebElement unselectbutton=driver.findElement(By.xpath("//input[@id='button-two']"));// Locate the second set of checkboxes and select them if not already selected
	 // unselectbutton.click();
	 List<WebElement>checkboxes2=driver.findElements(By.xpath("//input[@class='check-box-list']"));
	 for(WebElement checkbox2:checkboxes2)
		{
			if(!checkbox2.isSelected())
			{
				checkbox2.click();
			}
		}
	}

	public static void main(String[] args) {
		CheckBox check=new CheckBox();
		check.initialiseBrowser();
		check.checkbox();

	}

}
