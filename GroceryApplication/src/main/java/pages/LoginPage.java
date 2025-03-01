package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

	public LoginPage(WebDriver driver)// constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// driver.initialise
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinbutton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homepage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmessage;

	public void enterUserNameOnUsernameFiled(String username) throws IOException {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) throws IOException {
		passwordfield.sendKeys(password);
	}

	public HomePage loginUsingExcelData() throws IOException {
		String username = ExcelUtility.readstringData(1, 0, "LoginPage");
		usernamefield.sendKeys(username);
		String password = ExcelUtility.readstringData(1, 1, "LoginPage");
		passwordfield.sendKeys(password);
		signinbutton.click();
		return new HomePage(driver);
	}

	public HomePage clickOnSigninButton() {
		signinbutton.click();
		return new HomePage(driver);

	}

	public boolean isHomePageLoaded() {
		return homepage.isDisplayed();
	}

	public String getAlertMessage() {
		return alertmessage.getText();
	}
}
