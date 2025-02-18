package My_WAorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class etenderkerala {
	
	public WebDriver driver;
	public void initialiseBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://etenders.kerala.gov.in/nicgep/app");
	}
	public void credetials()
	{
	WebElement loginpage=driver.findElement(By.xpath("//img[@src='images/home_login_button_2.png']"));
	loginpage.click();
	
	driver.navigate().to("https://etenders.kerala.gov.in/nicgep/app?component=%24WebHomeBorder.%24WebRightMenu.login&page=Home&service=direct&session=T");
	WebElement username=driver.findElement(By.xpath("//input[@name='UserName']"));
	username.sendKeys("gopika@techpool.co.in");
	
	}

	public static void main(String[] args) 
	{
		etenderkerala tenders=new etenderkerala();
		tenders.initialiseBrowser();
		tenders.credetials();

	}

}
