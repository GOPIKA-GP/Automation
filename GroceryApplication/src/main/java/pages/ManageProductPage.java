package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageProductPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='badge bg-success']")
	WebElement productavailabilitybutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement productavailabilityaleart;
	@FindBy(xpath = "//span[@class='badge bg-danger']")
	WebElement productstockbutton;

	public ManageProductPage clickToUpdateProductAvailability() {
		pageutility.clickJavaScriptExecutor(productavailabilitybutton, driver);
		// waitutility.waitForWebElementAlert(driver);
		return this;
	}

	public boolean isProductAvailabilityUpdateAleartDisplayed() {
		return productavailabilityaleart.isDisplayed();
	}

	public ManageProductPage clickToUpdateProductStocksAvailability() {
		pageutility.clickJavaScriptExecutor(productstockbutton, driver);
		waitutility.waitForWebElementAlert(driver);
		return this;
	}

}
