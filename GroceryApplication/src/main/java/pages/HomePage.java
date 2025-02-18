package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	
	WebDriver driver;
	PageUtility pageutility=new PageUtility();

	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class='small-box-footer']")WebElement subcategory;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement category;
    @FindBy(xpath="//a[@class='d-block']")WebElement adminuser;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement managecontact;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")WebElement manageproduct;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenews; 
    public SubcategoryPage clickOnSubcategory() 
    {
    	subcategory.click();
    	return new SubcategoryPage(driver);
    }
    public CategoryPage clickOnCategory()
    {
    	pageutility.clickJavaScriptExecutor(category, driver);
    	return new CategoryPage(driver);
    }
    public AdminUserPage clickOnAdminUser()
    {
    	pageutility.clickJavaScriptExecutor(adminuser, driver);
    	return new AdminUserPage(driver);
    }
    public ManageContactPage clickOnManageContact()
	{
		pageutility.clickJavaScriptExecutor(managecontact, driver);
		return new ManageContactPage(driver);
	}
    public ManageProductPage clickOnManageProduct()
    {
    	pageutility.clickJavaScriptExecutor(manageproduct, driver);
    	return new ManageProductPage(driver);
    	
    }
    public ManageNewsPage clickOnManageNews()
    {
    	pageutility.clickJavaScriptExecutor(managenews, driver);
    	return new ManageNewsPage(driver);
    }
}
