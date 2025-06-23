package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.WorkersPage;

public class WorkersTest extends BaseClass{
	LoginPage login;
  @Test
  public void verifyTheWorkerButtonClick() {
	  login = new LoginPage(driver);
	  String username="carol";
	  String password="1q2w3e4r";
	  login.enterUserNameOnUsernameFiled(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickOnLoginButton();
	  WorkersPage worker=new WorkersPage(driver);
	  worker.clickOnWorkerButton();
	  boolean expectedResult=true;
	  boolean actualResult=worker.isWorkerPageLoaded();
	  Assert.assertEquals(actualResult, expectedResult,"Worker bage loding failed");
  }
}
