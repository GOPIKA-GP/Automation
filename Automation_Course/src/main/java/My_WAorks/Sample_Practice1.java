package My_WAorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sample_Practice1 {
	public WebDriver driver;
	public void initialaiseBrowser() {
		driver=new ChromeDriver();
		driver.get("https://gem.gov.in/");
	}
	public void quit() {
		driver.quit();
	}
	public void multiplewindowhandle() {
	WebElement parentwindow=driver.findElement(By.xpath("//a[@title='Need Help ?']"));
	parentwindow.click();
	
	WebElement droplist=driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
	Actions action=new Actions(driver);
	WebElement clickMe=driver.findElement(By.xpath("//a[@title='FAQs']"));
	action.moveToElement(clickMe).perform();
	action.sendKeys(Keys.ARROW_DOWN).perform();
	action.sendKeys(Keys.ARROW_DOWN).perform();
	clickMe.click();

	

	}

	public static void main(String[] args) {
		Sample_Practice1 practice=new Sample_Practice1();
		practice.initialaiseBrowser();
		practice.multiplewindowhandle();
		//practice.quit();

	}

}
