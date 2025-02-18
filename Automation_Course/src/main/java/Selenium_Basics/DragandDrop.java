package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop extends Base{

	public void draganddrophandling() 
	{
		driver.navigate().to("https://selenium.qabible.in/drag-drop.php");
		WebElement sourcedraggableelement1=driver.findElement(By.xpath("//span[text()='Draggable n°1' ]"));
		WebElement targetelement=driver.findElement(By.xpath("//div[@id='mydropzone']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(sourcedraggableelement1, targetelement).perform();
		WebElement sourcedraggableelement2=driver.findElement(By.xpath("//span[text()='Draggable n°2' ]"));
		action.dragAndDrop(sourcedraggableelement2, targetelement).perform();
		WebElement sourcedraggableelement3=driver.findElement(By.xpath("//span[text()='Draggable n°3' ]"));
		action.dragAndDrop(sourcedraggableelement3, targetelement).perform();
		WebElement sourcedraggableelement4=driver.findElement(By.xpath("//span[text()='Draggable n°4' ]"));
		action.dragAndDrop(sourcedraggableelement4, targetelement).perform();
	}
	public static void main(String[] args) {
		DragandDrop dragdrop=new DragandDrop();
		dragdrop.initialiseBrowser();
		dragdrop.draganddrophandling();
		//dragdrop.driverQuit();
	}

}
