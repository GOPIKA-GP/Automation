package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage homepage;
	ManageNewsPage managenews;
	
	
  @Test
  public void checkWhetherAdminCanCreateNewNewsOnTheWebApplication() throws IOException 
  {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  managenews=homepage.clickOnManageNews().clickOnNewNewsButton().enterTheNews().clickOnSaveButton();
	  
	  boolean isaleartpresent=managenews.isAleartMessageDispalyed();
	  Assert.assertTrue(isaleartpresent,Constant.managenews_sucessfullyMessageAlert);
  }
  
  
 @Test
 public void verifyIfAdminCanSearchANewsPublishedOnTheWebPage() throws IOException
 {
	 login=new LoginPage(driver);
	 homepage=login.loginUsingExcelData();
	 managenews=homepage.clickOnManageNews().clickOnSearchOption().enterDataToSearch().clickOnSearchButton();
	 
	 boolean isaleartpresent=managenews.isSearchAleartMessageDispalyed();
	 Assert.assertTrue(isaleartpresent, Constant.managenews_searchResultSucessfull);
	 
 }
 

 @Test
 public void checkIfAdminCanEditOnTheNewsPublished() throws IOException
 {
	  login=new LoginPage(driver);
	  homepage=login.loginUsingExcelData();
	  managenews=homepage.clickOnManageNews().clickOnSearchOption().enterDataToSearch().clickOnSearchButton()
			  .clickOnEditButton().enterTheEditedNews().clickOnUpdateButton();
	  
	  boolean isaleartpresent=managenews.isAleartMessageDispalyed();
	  Assert.assertTrue(isaleartpresent,Constant.managenews_sucessfullyMessageAlert);  
 }

}

