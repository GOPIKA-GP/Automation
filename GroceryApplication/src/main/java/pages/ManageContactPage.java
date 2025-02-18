package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {
	
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();
	
	
	public ManageContactPage(WebDriver driver)
	{
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement actionbutton;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumberfield;
	@FindBy(xpath="//input[@id='email']")WebElement emailfield;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement addressfield;
	@FindBy(xpath="//textarea[@placeholder='Enter Delivery Time']")WebElement deliverytimefield;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliverychargelimitfield;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement updatealeartmessage;
	
	
	public ManageContactPage clickOnActionButton()
	{
		pageutility.clickJavaScriptExecutor(actionbutton, driver);
		return this;
	}
	public ManageContactPage editPhoneNumberFiled()
	{
		phonenumberfield.clear();
		waitutility.waitUntilElementisVisisble(driver, phonenumberfield);
		
		String phonenumber="6564329226";
		phonenumberfield.sendKeys(phonenumber);
		return this;
	}
	public ManageContactPage editEmailFiled()
	{
		emailfield.clear();
		waitutility.waitUntilElementisVisisble(driver, emailfield);
		
		String email="xyzjbjb@gmail.com";
		emailfield.sendKeys(email);
		return this;
	}
	public ManageContactPage editAddressField()
	{
		addressfield.clear();
		waitutility.waitUntilElementisVisisble(driver, addressfield);
		
		String address="Nest,Hen, Australia via America";
		addressfield.sendKeys(address);
		return this;
	}
	public ManageContactPage editDeliverTimeField()
	{
		deliverytimefield.clear();
		waitutility.waitUntilElementisVisisble(driver, deliverytimefield);
		
		String deliveryt="15";
	    deliverytimefield.sendKeys(deliveryt);
		return this;
	}
	public ManageContactPage editDeliverChargeTimeField()
	{
		deliverychargelimitfield.clear();
		waitutility.waitUntilElementisVisisble(driver, deliverychargelimitfield);
		
		String deliveryct="60";
		deliverychargelimitfield.sendKeys(deliveryct);
		return this;
	}
	
	public ManageContactPage clickUpdateButton()
	{
		pageutility.clickJavaScriptExecutor(updatebutton, driver);
		return this;
	}
	public boolean isUpdatedContactDetails()
	{
		return updatealeartmessage.isDisplayed();
	}
}
