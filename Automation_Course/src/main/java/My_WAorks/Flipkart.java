package My_WAorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	
	public WebDriver driver;
	public void initialisebrowser() {
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	public void quitBrowser() {
		driver.quit();
	}
	public void search_beauty() {
		
	}

	public static void main(String[] args) {
		Flipkart shopping=new Flipkart();
		shopping.initialisebrowser();
		//shopping.quitBrowser();
	}

}
