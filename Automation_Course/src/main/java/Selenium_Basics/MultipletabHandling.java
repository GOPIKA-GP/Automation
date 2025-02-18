package Selenium_Basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MultipletabHandling extends Base {
	public void multiplewindow() {
		driver.navigate().to("https://selenium.qabible.in/window-popup.php");
		WebElement multiple=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		multiple.click(); //we have taken the site and selected the area for clicking.this will direst to a new window
		//Now we need to enter data in new opened window.So we need to switch to new window/switch to new window using get window handle
		String mainwindow=driver.getWindowHandle();
		System.out.println(mainwindow);//just to verify the main window loads
		Set<String> sets=driver.getWindowHandles();//driver.getWindowHandles() returns a set of window handles for all the open windows/tabs in the browser. The handles are stored in the sets variable
		Iterator<String> iterator1=sets.iterator();//An Iterator is created for the set of window handles. This will allow you to loop through the set and access each individual window handle.
		while(iterator1.hasNext())//The while loop checks if there is another window handle available.
		{
			String childwindow=iterator1.next();
			if(!mainwindow.equalsIgnoreCase(childwindow))//checks whether the current window handle (childwindow) is different from the main window (mainwindow). If they are different, it switches the WebDriver's focus to the child window using driver.switchTo().window(childwindow).
			{
				driver.switchTo().window(childwindow);
				WebElement emailadd=driver.findElement(By.xpath("(//input[@ name='email'])[2]"));
				emailadd.sendKeys("gopika@gmail.com");//Once in the child window, the script finds an email input field using the provided XPath (//input[@name='email'])[2] and enters the email gopika@gmail.com.
				//driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		}

	public static void main(String[] args) {
		MultipletabHandling multipletab=new MultipletabHandling();
		multipletab.initialiseBrowser();
		multipletab.multiplewindow();
		//multipletab.driverQuit();

	}

}
