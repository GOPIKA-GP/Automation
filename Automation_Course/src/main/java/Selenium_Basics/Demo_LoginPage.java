package Selenium_Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo_LoginPage {
	public WebDriver driver;
	public void initialiseBrowser() 
	{
		driver=new ChromeDriver();
		driver.get("https://www.qabible.in/payrollapp/site/login");
	}
	public void loginpagecommands()
	{
	WebElement usernameinput=driver.findElement(By.xpath("//input[@type='text']"));
	usernameinput.sendKeys("Gopika_g_p");
	WebElement passwordinput=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	passwordinput.sendKeys("Password_123");
	
	WebElement remenberme=driver.findElement(By.xpath("//label[@for='loginform-rememberme']"));
	//remenberme.click();
	//remenberme.click(); //can use click 2 times to select or de-select OR as mentioned below

	if(remenberme.isSelected())//disabled
	{
		remenberme.click();
	}
	boolean isrememebermebutton=remenberme.isSelected();//to check enable or not
	System.out.println(isrememebermebutton);//print on console
	
	WebElement clickonlogin=driver.findElement(By.xpath("//button[@type='submit']"));
	clickonlogin.click();
	}
	public void waits() {
	WebElement username=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	username.sendKeys("admin");
	WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	password.sendKeys("123");
	WebElement rememberme=driver.findElement(By.xpath("//input[@id='loginform-rememberme']"));
	rememberme.click();
	WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
	loginbutton.click();
WebElement errormessage=driver.findElement(By.xpath("//p[text()='Incorrect username or password.']"));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOf(errormessage));
	System.out.println(errormessage.getText());
	}
	public void Demo_LoginPageQuit()
	{
		driver.quit();
	}
	
	public static void main(String[] args) {
	
		Demo_LoginPage loginpage=new Demo_LoginPage();
		loginpage.initialiseBrowser();
		loginpage.loginpagecommands();
		loginpage.waits();
       //loginpage.Demo_LoginPageQuit();

	}

}
