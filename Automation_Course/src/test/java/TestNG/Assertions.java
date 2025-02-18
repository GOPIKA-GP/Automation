package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions extends TestNGBase {
  private WebElement showmessagebutton;
@Test
  public void elementCommands()
	{
	String input="Haiii";
	WebElement singleinputfield=driver.findElement(By.xpath("//input[@class='form-control']"));
	singleinputfield.sendKeys(input); 
	
	WebElement showmessagebutton=driver.findElement(By.xpath("//button[text()='Show Message']"));
	showmessagebutton.click();
	
	WebElement yourmessage=driver.findElement(By.xpath("//div[@id='message-one']"));
	String actualResult=yourmessage.getText();
	System.out.println(actualResult);
	
	String expectedResult="Your Message : "+input;
	Assert.assertEquals(expectedResult, actualResult," Expected Result is : "+expectedResult+ " but it is " +actualResult);// 3rd parameter is negative
																															//shows error message in case of failure

     
  boolean isshowmessagebuttondisplayed = showmessagebutton.isSelected();
  Assert.assertTrue(isshowmessagebuttondisplayed,"showmessagebutton is not displayed");
  driver.navigate().to("https://selenium.qabible.in/radio-button-demo.php");
  WebElement genderbutton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
  boolean isradiobuttonbeforeclickselected=genderbutton.isSelected();
  Assert.assertFalse(isradiobuttonbeforeclickselected, "radio button is selected before click");
  
  genderbutton.click();
  boolean isradiobuttonselectedafterclick=genderbutton.isSelected();
  Assert.assertTrue(isradiobuttonselectedafterclick, "radio button is not selected");
  int a=10,b=20;
  Assert.assertNotEquals(a,b,"a and b are equal");
  String s=null;
  Assert.assertNull(s, "String s contains a value");
  String name="Gopika";
  Assert.assertNotNull(name, "String name is null");
	} 

@Test
public void verifysofalert()
{
WebElement showmessagebutton=driver.findElement(By.xpath("//button[text()='Show Message']"));
boolean isshowmessagebuttondisplayed=showmessagebutton.isSelected();
SoftAssert softassert=new SoftAssert();
softassert.assertTrue(isshowmessagebuttondisplayed, "show message is not displayed");
driver.navigate().to("https://selenium.qabible.in/radio-button-demo.php");
WebElement genderbutton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
boolean isradiobuttonbeforeclickselected=genderbutton.isSelected();
softassert.assertFalse(isradiobuttonbeforeclickselected, "radio button is not selected");
softassert.assertAll();
}
}
