package Selenium_Basics;


public class BrowserCommands extends Base//By extending Base, your BrowserCommands class can reuse the 
                                         //initialiseBrowser() method and WebDriver setup from Base, 
 										//which is good for code reuse.
{

	public void browsercommands()
	{
		String url=driver.getCurrentUrl();// Gets the current URL of the page
		System.out.println(url);         // just to print the current URL of the page
		String title=driver.getTitle();  // Gets the title of the page
		System.out.println(title);       // print the title of the page
		String src=driver.getPageSource(); // Gets the page source (HTML)
		System.out.println(src);          // You might want to print only a small portion of this
	}
	public void navigationcommands()
	{
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	public static void main(String[] args) {
		BrowserCommands command=new BrowserCommands();
		command.initialiseBrowser();
		command.browsercommands();
		command.navigationcommands();
		//command.driverQuit();
	}
	

}
