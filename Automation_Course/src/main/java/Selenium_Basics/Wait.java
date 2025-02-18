package Selenium_Basics;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends Base {
	public void waitsample() {
		driver.navigate().to("https://www.qabible.in/payrollapp/site/login");
		
		//IMPLICIT WAIT
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//EXPLICIT WAIT
		
		WebDriverWait webwait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement loginbutton=driver.findElement(By.xpath("//button[@name='login-button']"));
		webwait.until(ExpectedConditions.visibilityOf(loginbutton));
		webwait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		webwait.until(ExpectedConditions.attributeContains(loginbutton,"name", "login-button"));
		webwait.until(ExpectedConditions.alertIsPresent());
		
		//FLUENT WAIT
		FluentWait<WebDriver> fluentwait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		fluentwait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		
	}

	public static void main(String[] args) {
		Wait wait=new Wait();
		wait.initialiseBrowser();
		wait.waitsample();
		//wait.driverQuit();

	}

}
