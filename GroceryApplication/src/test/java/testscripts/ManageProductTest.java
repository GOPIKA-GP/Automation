package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;

public class ManageProductTest extends BaseClass {
	LoginPage login;
	HomePage homepage;
	ManageProductPage manageproduct;

	@Test
	public void checkWhetherAdminCanManageExistingProductsStatus() throws IOException {
		login = new LoginPage(driver);
		homepage = login.loginUsingExcelData();
		manageproduct = homepage.clickOnManageProduct().clickToUpdateProductAvailability();

		boolean alertdisplayed = manageproduct.isProductAvailabilityUpdateAleartDisplayed();
		Assert.assertTrue(alertdisplayed, "Product Status Changed Successfully");
	}
}