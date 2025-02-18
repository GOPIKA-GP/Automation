package My_WAorks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GEM_Activites {// Set the path to the ChromeDriver executable
	public WebDriver driver; //declare driver variable--import WebDriver
    public void initialisebrowser() {// Initialize the browser
    	driver=new ChromeDriver(); // Create a new instance of ChromeDriver--import ChromeDriver
    	driver.get("https://gem.gov.in/"); // Open the URL in the browser
    }
    public void closebrowser() { // To close the browser once the work is done
    	driver.quit();// Closes the browser and ends the WebDriver session
    }
    
    public void bid_search() {
    	WebElement bidsearch=driver.findElement(By.xpath("//a[@title='Bids']"));// Locate the element using XPath (the link with title 'Bids')
    	 // Ensure the element is clickable before clicking it
    	if (bidsearch.isDisplayed() && bidsearch.isEnabled()) {
    	bidsearch.click(); // Click the 'Bids' link
    	}
    	else
    	{
            System.out.println("The 'Bids' link is not visible or clickable.");
        }
    	Actions action=new Actions(driver);
    	action.moveToElement(bidsearch).perform();
    	WebElement scroll=driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[12]"));
    	action.sendKeys(Keys.ARROW_DOWN).perform();
    
    	
    }
	public static void main(String[] args) {
		GEM_Activites gemsite=new GEM_Activites();
		gemsite.initialisebrowser();
		gemsite.bid_search();
		//gemsite.closebrowser();

	}

}
