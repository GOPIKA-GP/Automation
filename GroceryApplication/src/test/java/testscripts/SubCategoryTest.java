package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.SubcategoryPage;

public class SubCategoryTest extends BaseClass
{
	  LoginPage login;
	  HomePage homepage;
	  SubcategoryPage scpage;
	  
	  
  @Test
  public void verifyIfAdminCanAddNewSubcategoryWithValidDetails() throws IOException 
  {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  scpage=homepage.clickOnSubcategory().clickOnNewSubCategoryButton().clickOnCategoryDropDown()
			  			.enterSubCategoryField().clickOnSaveButton();
	  
	  boolean isaleartpresent=scpage.isAleartDisplayed();
	  Assert.assertTrue(isaleartpresent, Constant.sc_AlertMaessage1);  
  }
  
  @Test
  public void checkWhetherAdminCanSearchwithInvalidSubCategory() throws IOException
  {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  scpage=homepage.clickOnSubcategory().clickOnSubCategeorySearchButton()
			    .searchListSubCategoriesdropdown().searchListSubCategoriesdropdown()
	  			.enterseachSubCategoryField().clickonSeachButton();
	 
	  boolean isaleartpresent=scpage.isSearchResultsValid();
	  Assert.assertTrue(isaleartpresent,Constant.sc_InvalidDataAlert); 
  }
 
  @Test
  public void checkIfAdminCanEditAnExisingSubCategorySucessfully() throws IOException
  {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  scpage=homepage.clickOnSubcategory().clickOnSubCategeorySearchButton().enterDataOfSubCategoryField()
			  .clickonEditButton().clickonUploadPhotoOption().clickonUpdateButton(); 
	  
	  boolean updatealeart=scpage.isUpdateAleartDisplayed();
	  Assert.assertTrue(updatealeart,Constant.sc_AlertMaessage2); 
	  
  }

}
