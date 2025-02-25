package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	public WebDriver driver;
	public String selectDropdownWithValue(WebElement element, String value) 
	{
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public String selectDropdownWithText(WebElement element, String text) 
	{
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int indexNumber) 
	{
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) 
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}
	
	public int random(int limit) 
	{
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
    public String generateCurrentDateAndTime() 
    {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
    public static void doubleClick(WebDriver driver, WebElement element) 
    {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
    public static void selectAllText(WebDriver driver, WebElement element) 
    {
    	Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys(Keys.CONTROL + "A").perform();
    }
    
  
}
