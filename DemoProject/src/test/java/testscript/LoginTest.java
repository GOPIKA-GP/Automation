package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
  @Test
  public void verifyUserLoginWithValidCredentials() 
  {
	  LoginPage login=new LoginPage(driver);
	  String username="carol";
	  String password="1q2w3e4r";
	  login.enterUserNameOnUsernameFiled(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickOnLoginButton();
	  boolean expectedResult=true;
	  boolean actualResult=login.isHomePageLoaded();
	  Assert.assertEquals(actualResult, expectedResult,"Login Failed for valid credentials");
  }
  @Test
  public void verifyUserLoginWithInvalidUsenameAndValidPassword()
  {
	  LoginPage login=new LoginPage(driver);
	  String username="Gopika";
	  String password="1q2w3e4r";
	  login.enterUserNameOnUsernameFiled(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickOnLoginButton();
	  //boolean expectedResult=true;
	  boolean actualResult=login.getAlertMessage().contains("Incorrect username or password.");
	  Assert.assertTrue(actualResult, "Aleart message is not expected");  
  }
  @Test
  public void verifyUserLoginWithValidUsenameAndInvalidPassword()
  {
	  LoginPage login=new LoginPage(driver);
	  String username="carol";
	  String password="1q2w3e4rr";
	  login.enterUserNameOnUsernameFiled(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickOnLoginButton();
	  boolean actualResult=login.getAlertMessage().contains("Incorrect username or password.");
	  Assert.assertTrue(actualResult, "Aleart message is not expected");  
  }
  @Test(dataProvider="dataprovider1")
  public void verifyUserLoginWithInvalidUsenameAndInvalidPassword(String username,String password)
  {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameOnUsernameFiled(username);
	  login.enterPasswordOnPasswordField(password);
	  login.clickOnLoginButton();
	  boolean actualResult=login.getAlertMessage().contains("Incorrect username or password.");
	  Assert.assertTrue(actualResult, "Aleart message is not expected");  
  }
  @DataProvider(name="dataprovider1")
  public Object[][] dpmethod(){
	  return new Object[][] 
	{{"Gopika","1fvf0"},{"devika","6bgfbfg5"},{"beetha","vkvfkvk"},{"kalluz4","vdfd8"}};
  }
}
