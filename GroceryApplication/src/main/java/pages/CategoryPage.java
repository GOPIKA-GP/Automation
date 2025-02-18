package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	FileUploadUtility fileuploadutility=new FileUploadUtility();
	WaitUtility waitutility=new WaitUtility();
	
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newcategorybutton;
	@FindBy(xpath="//input[@id='category']")WebElement categoryfield;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement selectgroups;
	@FindBy(xpath="//input[@type='file']")WebElement uploadimage;
	@FindBy(xpath="//input[@name='top_menu' and @checked='checked' ]")WebElement showontopmenuradiobutton;
	@FindBy(xpath="//input[@name='show_home' and @checked='checked' ]")WebElement showonleftmenuradiobutton;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertcreatecategory;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchbutton;
	@FindBy(xpath="//input[@name='un']")WebElement entercategoryname;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix' and @name='Search']")WebElement clicksearch;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")WebElement searchresult;
	
	@FindBy(xpath="//a[@role='button']")WebElement statusbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement statusaleartmessage;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/category/edit?edit=569&page_ad=1']")WebElement editbutton;
	
	
	public CategoryPage clickOnNewCategoryButton()
	{
		pageutility.clickJavaScriptExecutor(newcategorybutton, driver);
		return this;
	}
	public CategoryPage enterNewCategoryName()
	{
		String categoryname="Fashion"+pageutility.generateCurrentDateAndTime();
		categoryfield.sendKeys(categoryname);
		waitutility.waitUntilElementisVisisble(driver, categoryfield);
		return this;
	}
	public CategoryPage clickOnSelectGroups() 
	{	
		selectgroups.click();
		return this;
	}
	public CategoryPage uploadImage()
	{
		pageutility.clickJavaScriptExecutor(uploadimage, driver);
		
		String imagePath = System.getProperty("user.dir") + "/src/test/resources/images/FASHION.jpg";
	    fileuploadutility.fileuploadingusingsendkeys(uploadimage, imagePath);
	    
	    waitutility.waitUntilImageisVisisble(driver, uploadimage);
	    return this;
	}
	public CategoryPage clickOnRadioButtons()
	{
		pageutility.clickJavaScriptExecutor(showontopmenuradiobutton, driver);
		waitutility.waitUntilElementisVisisble(driver, showontopmenuradiobutton);
		
		pageutility.clickJavaScriptExecutor(showonleftmenuradiobutton, driver);
		waitutility.waitUntilElementisVisisble(driver, showonleftmenuradiobutton);
		return this;
	}
	public CategoryPage clickOnSaveButton()
	{
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		return this;
	}
	public boolean isaleartNewCategoryAdded()
	{
		return alertcreatecategory.isDisplayed();
	}
	
	public CategoryPage clickOnSearchOption()
	{
		pageutility.clickJavaScriptExecutor(searchbutton, driver);
		return this;
	}
	public CategoryPage enterTheSearchDetails()
	{
		String categorysearchname="Gold and Silver";
		entercategoryname.sendKeys(categorysearchname);
		return this;
	}
	public CategoryPage clickOnSearchCategoryButton()
	{
		pageutility.clickJavaScriptExecutor(clicksearch, driver);
		waitutility.waitForsearchOption(driver);
		return this;
	}
	
	public boolean isSearchResultAppears()
	{
		return searchresult.isDisplayed();
	}
	public CategoryPage clickOnStatusButton()
	{
		pageutility.clickJavaScriptExecutor(statusbutton, driver);
		waitutility.waitUntilElementisVisisble(driver, statusbutton);
		return this;
	}
	public boolean isStatusChanged()
	{
		return statusaleartmessage.isDisplayed();
	}
	
	public CategoryPage enterTheSearchDetailsOfCategory()
	{
		String categorysearchname="icecream";
		entercategoryname.sendKeys(categorysearchname);
		return this;
	}
	
	public CategoryPage clickOnEditCategoryButton()
	{
		pageutility.clickJavaScriptExecutor(editbutton, driver);
		return this;
	}
	public CategoryPage editCategoryDatas()
	{
		categoryfield.clear();
		String categoryname2="cake";
		categoryfield.sendKeys(categoryname2);
		waitutility.waitUntilElementisVisisble(driver, categoryfield);
		
		pageutility.clickJavaScriptExecutor(uploadimage, driver);
		String imagePath = System.getProperty("user.dir") + "/src/test/resources/images/icecream.jpg";
	    fileuploadutility.fileuploadingusingsendkeys(uploadimage, imagePath);
	    waitutility.waitUntilImageisVisisble(driver, uploadimage);
		
		return this;
	}
	
}
	
