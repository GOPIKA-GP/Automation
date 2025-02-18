package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;
	
 public class SubcategoryPage
 {
		
	public 	WebDriver driver;
	PageUtility pageutility=new PageUtility();
	FileUploadUtility fileuploadutility=new FileUploadUtility();
	WaitUtility waitutility=new WaitUtility();
	
	public SubcategoryPage(WebDriver driver)
	{
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newsubcategorybutton;
	@FindBy(xpath="//select[@name='cat_id']")WebElement categorydropdown;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subcategoryfield;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement aleartmessage;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement subcategorysearchbutton;
	@FindBy(xpath="//select[@class='form-control selectpicker']")WebElement subcategorysearchdropdown;
	@FindBy(xpath="//input[@class='form-control']")WebElement subcategorysearchfield;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement clickonsearchbutton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")WebElement notfoundmessage;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=2620&page_ad=1']")WebElement editbutton;
	@FindBy(xpath="//input[@name='main_img']")WebElement imageuploadoption;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement updatealeart;
	
	public SubcategoryPage clickOnNewSubCategoryButton()
	{
		pageutility.clickJavaScriptExecutor(newsubcategorybutton, driver);
		return this;
	}
	
	public SubcategoryPage clickOnCategoryDropDown() 
	{
		pageutility.selectDropdownWithText(categorydropdown, "Toys");
		waitutility.waitUntilElementisVisisble(driver, categorydropdown);
		return this;
	}
	
	public SubcategoryPage enterSubCategoryField()
	{
		String subcategoryname="SOFT TOYS"+pageutility.generateCurrentDateAndTime();
		subcategoryfield.sendKeys(subcategoryname);
		waitutility.waitUntilElementisVisisble(driver, subcategoryfield);
		return this;
	}
	
	public SubcategoryPage clickOnSaveButton()
	{
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		waitutility.waitUntilElementisVisisble(driver, savebutton);
		return this;
	}
	public boolean isAleartDisplayed() 
	{
	 return aleartmessage.isDisplayed();
	}
   
	//search option
	public SubcategoryPage clickOnSubCategeorySearchButton()
    {
		pageutility.clickJavaScriptExecutor(subcategorysearchbutton, driver);
    	return this;
    }
    public SubcategoryPage searchListSubCategoriesdropdown()
    {
    	pageutility.selectDropdownWithText(subcategorysearchdropdown, "Vegetables");
    	waitutility.waitUntilElementisVisisble(driver, subcategorysearchdropdown);
    	return this;
    }
    public SubcategoryPage enterseachSubCategoryField()
	{
		String subcategorysearchname="carrot";
		subcategorysearchfield.sendKeys(subcategorysearchname);
		waitutility.waitUntilElementisVisisble(driver, subcategorysearchfield);
		return this;
	}
    public SubcategoryPage clickonSeachButton() 
    {
        pageutility.clickJavaScriptExecutor(clickonsearchbutton, driver);
        waitutility.waitUntilElementisVisisble(driver, clickonsearchbutton);
        return this;
    }
    public boolean isSearchResultsValid()
    {
    	return notfoundmessage.isDisplayed();
    }
    public SubcategoryPage enterDataOfSubCategoryField()
   	{
    	pageutility.selectDropdownWithText(subcategorysearchdropdown, "Toys");
    	waitutility.waitUntilElementisVisisble(driver, subcategorysearchdropdown);
    	
   		String subcategorysearchname="soft";
   		subcategorysearchfield.sendKeys(subcategorysearchname);
   		//waitutility.waitUntilElementisVisisble(driver, subcategorysearchfield);
   		return this;
   	}
    public SubcategoryPage clickonEditButton()
    {
    	pageutility.clickJavaScriptExecutor(editbutton, driver);
    	//waitutility.waitUntilElementisVisisble(driver, editbutton);
    	return this;
    }
    public SubcategoryPage clickonUploadPhotoOption()
    {
    	//imageuploadoption.click();
    	//pageutility.clickJavaScriptExecutor(imageuploadoption, driver);
		String imagePath = System.getProperty("user.dir")+"\\src\\test\\resources\\images\\softtoys.jpg";
	    fileuploadutility.fileuploadingusingsendkeys(imageuploadoption, imagePath);
    	return this;
    }
    public SubcategoryPage clickonUpdateButton()
    {
    	pageutility.clickJavaScriptExecutor(updatebutton, driver);
    	return this;
    }
    public boolean isUpdateAleartDisplayed()
    {
    	return updatealeart.isDisplayed();
    }

}