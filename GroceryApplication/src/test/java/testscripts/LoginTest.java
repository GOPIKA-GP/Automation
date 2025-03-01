package testscripts;

import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.LoginPage;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.Assert;

public class LoginTest extends BaseClass {

	@Test(priority = 3)
	public void verifyUserLoginWithInvalidUsenameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = "Gopika";
		String password = "admin";
		login.enterUserNameOnUsernameFiled(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		boolean actualResult = login.getAlertMessage().contains("Invalid Username/Password");
		Assert.assertTrue(actualResult, Constant.lp_alertmessage);
	}

	@Test(priority = 4)
	public void verifyUserLoginWithValidUsenameAndInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = "admin";
		String password = "1q2w3e4rr";
		login.enterUserNameOnUsernameFiled(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		boolean actualResult = login.getAlertMessage().contains("Invalid Username/Password");
		Assert.assertTrue(actualResult, Constant.lp_alertmessage);
	}

	@Test(dataProvider = "dataprovider1", priority = 2, groups = "smoke")
	public void verifyUserLoginWithInvalidUsenameAndInvalidPassword(String username, String password)
			throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUsernameFiled(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		boolean actualResult = login.getAlertMessage().contains("Invalid Username/Password");
		Assert.assertTrue(actualResult, Constant.lp_alertmessage);
	}

	@DataProvider(name = "dataprovider1")
	public Object[][] dpmethod() {
		return new Object[][] { { "Gopika", "1fvf0" }, { "devika", "6bgfbfg5" }, { "beetha", "vkvfkvk" },
				{ "kalluz4", "vdfd8" } };
	}

	@Test(priority = 1, groups = "smoke")
	public void verifyUserLoginWithValidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.loginUsingExcelData();
		// login.clickOnSigninButton();
		boolean expectedResult = true;
		boolean actualResult = login.isHomePageLoaded();
		Assert.assertEquals(actualResult, expectedResult, Constant.lp_loginfailwarning);
	}

}
