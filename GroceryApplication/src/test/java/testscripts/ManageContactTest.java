package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage homepage;
	ManageContactPage managecontactpage;  
  
	@Test
  public void verifyIfAdminCanUpdateContactDetails() throws IOException 
	{
		  login=new LoginPage(driver);
		  homepage=login.loginUsingExcelData();
		  managecontactpage=homepage.clickOnManageContact().clickOnActionButton()
				  .editPhoneNumberFiled().editEmailFiled().editAddressField().editDeliverTimeField()
				  .editDeliverChargeTimeField().clickUpdateButton();
		  
		  boolean isaleartmsgdisplayed=managecontactpage.isUpdatedContactDetails();
		  Assert.assertTrue(isaleartmsgdisplayed,Constant.managecontact_SuccesAlert);
		  
    }
}
