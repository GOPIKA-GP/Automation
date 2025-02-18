package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUserTest extends BaseClass {
	
	  LoginPage login;
	  HomePage homepage;
	  AdminUserPage adminuser;
	  
  @Test(groups="smoke")
  public void checkIfNewAdminUserCanBeCreate() throws IOException 
  {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  adminuser=homepage.clickOnAdminUser().manageCategoryPage().clickOnNewButton().enterUserNameInField()
			  .enterPasswordInField().userTypeDropDrown().clickOnSaveButton();
			    
	 boolean isAlertMessageShown = adminuser.isNewAdminUserCreated();
	 Assert.assertTrue(isAlertMessageShown,Constant.adminuser_SuccessAlert);
  }
  
  
  @Test(groups="smoke")
  public void checkIfAdminCanSearchNewAddedUser() throws IOException
  {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  adminuser=homepage.clickOnAdminUser().manageCategoryPage().clickOnSearchButton().enterSearchUsername()
			  .clickOnSearchUserButton();
	  
	 boolean issearchresult=adminuser.isSearchAdminUserDisplayed();
	 Assert.assertEquals(issearchresult,true,Constant.adminuser_SearchData);  
  }
  
  @Test
  public void verifyWhetherAdminCanEditUserData() throws IOException
  {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  adminuser=homepage.clickOnAdminUser().manageCategoryPage().clickOnSearchButton().enterSearchUsername()
			  .clickOnSearchUserButton().clickOnEditButton().editPasswordInField().clickOnUpdateButton();
	  
	  boolean isUpdateAlertMessageShown = adminuser.isUserDetailsUpdated();
		 Assert.assertTrue(isUpdateAlertMessageShown,Constant.adminuser_SuccessAlert); 
  }
  
  
}
