package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newcreatenewsbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsfield;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement aleartmessage;

	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement searchoption;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement searchfield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchbutton;
	@FindBy(xpath = "//td[text()='New User....!!! Get 7% Discount On Your First Purchase...']")
	WebElement searchalert;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss' and @role='button']")
	WebElement editbutton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement editnewsfield;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement updatebutton;
	@FindBy(xpath = "//td[text()='New User....!!! Get 7% Discount On Your First Purchase...']")
	WebElement newsfieldtoupdate;

	public ManageNewsPage clickOnNewNewsButton() {
		pageutility.clickJavaScriptExecutor(newcreatenewsbutton, driver);
		return this;
	}

	public ManageNewsPage enterTheNews() {
		String newnews = "New User....!!! Get 7% Discount On Your First Purchase... ";
		newsfield.sendKeys(newnews);
		waitutility.waitUntilElementisVisisble(driver, newsfield);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		waitutility.waitUntilElementisVisisble(driver, savebutton);
		return this;
	}

	public boolean isAleartMessageDispalyed() {
		return aleartmessage.isDisplayed();
	}

	public ManageNewsPage clickOnSearchOption() {
		pageutility.clickJavaScriptExecutor(searchoption, driver);
		return this;
	}

	public ManageNewsPage enterDataToSearch() {
		pageutility.clickJavaScriptExecutor(searchfield, driver);
		String searchdata = "First purchase";
		waitutility.waitUntilElementisVisisble(driver, searchfield);
		searchfield.sendKeys(searchdata);
		return this;
	}

	public ManageNewsPage clickOnSearchButton() {
		pageutility.clickJavaScriptExecutor(searchbutton, driver);
		return this;
	}

	public boolean isSearchAleartMessageDispalyed() {
		return searchalert.isDisplayed();
	}

	public ManageNewsPage clickOnEditButton() {
		pageutility.clickJavaScriptExecutor(editbutton, driver);
		return this;
	}

	public ManageNewsPage enterTheEditedNews() {
		// editnewsfield.clear();
		editnewsfield.sendKeys("NOO...MORE DISCOUND...!!! GET FLAT 40% OFF NOW...!!");

		return this;
	}

	public ManageNewsPage clickOnUpdateButton() {
		pageutility.clickJavaScriptExecutor(updatebutton, driver);
		return this;
	}

}
