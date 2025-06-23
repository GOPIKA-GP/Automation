package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkersPage {
	public WebDriver driver;
	public WorkersPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//driver.initialise
	}
	@FindBy(xpath="//href[a='payrollapp/worker/index']")WebElement clickOnWorkers;
	
	
	public void clickOnWorkerButton() 
	{
		clickOnWorkers.click();
	}
	public boolean isWorkerPageLoaded() 
	{
		return clickOnWorkers.isDisplayed();
	}
}
