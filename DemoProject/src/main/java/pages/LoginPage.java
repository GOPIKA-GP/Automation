package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//driver.initialise
	}
	@FindBy(xpath="//input[@id='loginform-username']")WebElement usernamefield;
	@FindBy(xpath="//input[@id='loginform-password']")WebElement passwordfield;
	@FindBy(xpath="//button[@name='login-button']")WebElement loginbutton;
	@FindBy(xpath="//h1[text()='Payroll Application']")WebElement homepage;
	@FindBy(xpath="//p[text()='Incorrect username or password.']")WebElement alertmessage;
	
	
	public void enterUserNameOnUsernameFiled(String username)
	{
		usernamefield.sendKeys(username);
	}
	public void enterPasswordOnPasswordField(String password)
	{
		passwordfield.sendKeys(password);
	}
	public void clickOnLoginButton() 
	{
		loginbutton.click();
	}
	public boolean isHomePageLoaded() 
	{
		return homepage.isDisplayed();
	}
	public String getAlertMessage()
	{
		return alertmessage.getText();
	}
}
