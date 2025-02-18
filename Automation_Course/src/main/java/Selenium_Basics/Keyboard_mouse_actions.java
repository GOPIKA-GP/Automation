package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Keyboard_mouse_actions extends Base {
	public void actions() {
		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/buttons.php");
		Actions action=new Actions(driver);
		WebElement clickMe=driver.findElement(By.xpath("//button[@onclick='showDiv()']"));
		clickMe.click();// single click
		
		WebElement rightClick=driver.findElement(By.xpath("//button[@onclick='fn(event);']"));
		action.contextClick(rightClick).perform();//right click use context click//contextClick() simulates a right-click on the element
		
		WebElement doubleClick=driver.findElement(By.xpath("//button[@ondblclick='myDoubleclick()']"));
		action.doubleClick(doubleClick).perform(); //double click
		
		action.moveToElement(clickMe).perform();//to mouse over action
		
		action.sendKeys(Keys.ARROW_DOWN).perform();//moving down
		
		WebElement movedown=driver.findElement(By.xpath("//a[@href='text-box.php']"));
		action.moveToElement(movedown).perform();//mouse overing and to move down
		action.sendKeys(Keys.ARROW_DOWN).perform();//move down
	}

	public static void main(String[] args) {
		Keyboard_mouse_actions kbmouuseaction=new Keyboard_mouse_actions();
		kbmouuseaction.initialiseBrowser();
		kbmouuseaction.actions();
		//kbmouuseaction.driverQuit();
		

	}

}
