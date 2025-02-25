package testscripts;


import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.Assert;

import automationcore.BaseClass;
import constants.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseClass  {
	
		  LoginPage login;
		  HomePage homepage;
		  CategoryPage categorypage;
	
		  @Test
		  public void verifyIfAdminUserCanAddANewCategoryWithValidDetails() throws IOException
		  {
			  login=new LoginPage(driver);
			  homepage=login.loginUsingExcelData();
			  categorypage=homepage.clickOnCategory().clickOnNewCategoryButton().enterNewCategoryName()
					  				.clickOnSelectGroups().uploadImage().clickOnSaveButton();
					  				
		      boolean actualresult=categorypage.isaleartNewCategoryAdded();
		      Assert.assertTrue(actualresult, Constant.ctgy_AlertMessage1);
		  }
		  
		  @Test
		  public void checkWhetherAdminUserCanSearchAnInvalidCategory() throws IOException
		  {
			  login=new LoginPage(driver);
			  homepage=login.loginUsingExcelData();
			  categorypage=homepage.clickOnCategory().clickOnSearchOption().enterTheSearchDetails().clickOnSearchCategoryButton();

			  boolean actualresult=categorypage.isSearchResultAppears();
			  Assert.assertTrue(actualresult,Constant.ctgy_NotFoundAlert);
		  }
		  
		  @Test
		  public void checkIfAdminUserCanChangeCategoryStatus() throws IOException
		  {
			  login=new LoginPage(driver);
			  homepage=login.loginUsingExcelData();
			  categorypage=homepage.clickOnCategory().clickOnStatusButton();
			
			  boolean actualresult=categorypage.isStatusChanged();
			  Assert.assertTrue(actualresult, Constant.ctgy_AlertMessage2);
		  }
		  
		  @Test
		  public void verifyWhetherAdminUserCanEditDatasOfAnExistingCategory() throws IOException
		  {
			  login=new LoginPage(driver);
			  homepage=login.loginUsingExcelData();
			  categorypage=homepage.clickOnCategory().clickOnSearchOption().enterTheSearchDetailsOfCategory().
					  clickOnSearchCategoryButton().clickOnEditCategoryButton().clickOnSaveButton();
			
			  boolean actualresult=categorypage.isaleartNewCategoryAdded();
		      Assert.assertTrue(actualresult, Constant.ctgy_AlertMessage1);
		  }
}
