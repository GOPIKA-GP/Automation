package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();
	FakerUtility fakerutility=new FakerUtility();
	
	public AdminUserPage(WebDriver driver)
	{
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusersbutton;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']")WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertypedropdown;
	@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement adminusercreatsucessaleart;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton; 
	@FindBy(xpath="//input[@id='un']")WebElement searchusername;
	@FindBy(xpath="//button[@value='sr']")WebElement searchclickbutton;
	@FindBy(xpath="//input[@id='un']")WebElement searchresult; 
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editbutton;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement updatebutton;
	@FindBy(xpath="////img[@class='img-circle elevation-2']")WebElement successalert;
	
	public AdminUserPage manageCategoryPage()
	{
	pageutility.clickJavaScriptExecutor(adminusersbutton, driver);
	waitutility.implicitWaitForNewFrame(driver);
	return this;
	
	}
	public AdminUserPage clickOnNewButton()
	{
		pageutility.clickJavaScriptExecutor(newbutton, driver);
		return this;
	}
	public AdminUserPage enterUserNameInField()
	{
		String username=fakerutility.generateFullName();
		usernamefield.sendKeys(username);
		waitutility.waitUntilElementisVisisble(driver, usernamefield);
		return this;
	}
	public AdminUserPage enterPasswordInField()
	{
		String password="password";
		passwordfield.sendKeys(password);
		waitutility.waitUntilElementisVisisble(driver, passwordfield);
		return this;
	}
	public AdminUserPage userTypeDropDrown()
	{
		pageutility.selectDropdownWithIndex(usertypedropdown, 1);
		pageutility.clickJavaScriptExecutor(usertypedropdown, driver);
		waitutility.waitUntilElementisVisisble(driver, usertypedropdown);
		return this;
	}
	public AdminUserPage clickOnSaveButton()
	{
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		return this;
	}
	public boolean isNewAdminUserCreated()
	{
		return adminusercreatsucessaleart.isDisplayed();
	}
	public AdminUserPage clickOnSearchButton()
	{
		pageutility.clickJavaScriptExecutor(searchbutton, driver);
		return this;
	}
	public AdminUserPage enterSearchUsername()
	{
		pageutility.clickJavaScriptExecutor(searchusername, driver);
		String searchname="Aditi";
		searchusername.sendKeys(searchname);
		return this;
	}
	public AdminUserPage clickOnSearchUserButton()
	{
		pageutility.clickJavaScriptExecutor(searchclickbutton, driver);
		return this;
	}
	public boolean isSearchAdminUserDisplayed()
	{
		return searchresult.isDisplayed();
	}
	
	public AdminUserPage clickOnEditButton()
	{
		pageutility.clickJavaScriptExecutor(editbutton, driver);
		return this;
	}
	public AdminUserPage editPasswordInField()
	{
		String password="password123";
		passwordfield.sendKeys(password);
		waitutility.waitUntilElementisVisisble(driver, passwordfield);
		return this;
	}
	public AdminUserPage clickOnUpdateButton()
	{
		pageutility.clickJavaScriptExecutor(updatebutton, driver);
		return this;
	}
	public boolean isUserDetailsUpdated()
	{
		return successalert.isDisplayed();
	}
}
