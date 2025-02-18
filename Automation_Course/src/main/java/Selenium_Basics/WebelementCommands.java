package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebelementCommands extends Base {
	/*public void locatorsDemo()//sample demo part
	{
		WebElement entermessage=driver.findElement(By.id("value-b"));
		WebElement classdemo1=driver.findElement(By.className("form-control"));
		WebElement tagsample1=driver.findElement(By.tagName("input"));
		
		WebElement gettotalbutton=driver.findElement(By.id("button-two"));
		WebElement classdemo2=driver.findElement(By.className("btn btn-primary"));
		WebElement tagdemo2=driver.findElement(By.tagName("button"));
		
		WebElement totalvalue=driver.findElement(By.id("message-two"));
		WebElement classdemo3=driver.findElement(By.className("my-2"));
		WebElement tagdemo3=driver.findElement(By.tagName("div"));
	}*/
	public void locators()
	{
	WebElement showmessagebutton=driver.findElement(By.id("button-one"));//find using id
	WebElement classsample=driver.findElement(By.className("form-control"));//find using class
	WebElement tagsample=driver.findElement(By.tagName("button"));//find using tag
	WebElement namesample=driver.findElement(By.name("viewport"));//find using name
	WebElement linktext=driver.findElement(By.linkText("Simple Form Demo"));//find using a link text
	WebElement partiallinktext=driver.findElement(By.partialLinkText("Simple Form"));//find using partial text
	
	WebElement XPath=driver.findElement(By.xpath("//button[@id='button-one']"));//find using xpath for id
	driver.findElement(By.xpath("//button[@class='btn btn-primary']"));//find using xpath for class
	driver.findElement(By.xpath("//button[contains(@class,'btn btn')]"));//Contains part of the element
	driver.findElement(By.xpath("//button[text()='Show Message']"));//using text
	driver.findElement(By.xpath("starts-with(text(),'Show')]"));//using starts with partial message/text
	driver.findElement(By.xpath("//button[@id='button-one' and @class='btn btn-primary']"));//using 2 attributes
	driver.findElement(By.xpath("//button[@id='button-one' or @class='btn btn-primary']"));//use any 1 of the attribute
	driver.findElement(By.xpath("//div[contains(text(),'Single Input Field')]//parent::div[ @class='card']"));//using child-parent
	driver.findElement(By.xpath("//div[@class='card-body']//child::button[@class='btn btn-primary']"));//using parent-child
	driver.findElement(By.xpath("//button[@id='button-one']//following::div[@class='card']"));//following
	driver.findElement(By.xpath("//button[@id='button-one']//preceding::div[@class='card']"));//preceding
	
	driver.findElement(By.cssSelector("input#single-input-field"));//find using css selector//css=tag#id
	driver.findElement(By.cssSelector("input.form-control"));//css=tag.class
	driver.findElement(By.cssSelector("input[id='value-a']"));//css=tag[attribute=value]
	driver.findElement(By.cssSelector("input.form-control[id='single-input-field']"));//css=tag.classname[attribute=value]
	}
	
	public void elementCommands()
	{
	WebElement singleinputfield=driver.findElement(By.xpath("//input[@class='form-control']"));//locate the field
	singleinputfield.sendKeys("Haiii"); //send keys are used to pass the message on the fields
	singleinputfield.clear(); //clear the message given in the field
	singleinputfield.sendKeys("Helooo");//sending message
	
	WebElement showmessagebutton=driver.findElement(By.xpath("//button[text()='Show Message']"));//locate the field
	showmessagebutton.click();//for clicking the button .can double click also
	
	WebElement yourmessage=driver.findElement(By.xpath("//div[@id='message-one']"));
	String message=yourmessage.getText();//displaying the message
	System.out.println(message);//for printing message in console
	boolean isshowmessagebuttondisplayed=showmessagebutton.isDisplayed();//to check whether msg is displayed or not
	System.out.println(isshowmessagebuttondisplayed);//print the result
	boolean isshowmessagebuttonenabled=showmessagebutton.isEnabled();//to check whether enabled or not
	System.out.println(isshowmessagebuttonenabled);//print the result
	
	String fontsizeofshowmessagebutton=showmessagebutton.getCssValue("font-size");//to know the font size---use getCss vale to print any properties like background colour etc.
	System.out.println(fontsizeofshowmessagebutton);//print the fonts size on console 
	int xaxis=showmessagebutton.getLocation().getX();
	System.out.println(xaxis);
	int yaxis=showmessagebutton.getLocation().getY();
	System.out.println(yaxis);
	
	WebElement entervaluea=driver.findElement(By.xpath("//input[@id='value-a']"));//entering values
	entervaluea.sendKeys("5");
	WebElement entervalueb=driver.findElement(By.xpath("//input[@id='value-b']"));//entering values
	entervalueb.sendKeys("10");
	WebElement gettotalbutton=driver.findElement(By.xpath("//button[@id='button-two']"));//click on total
	gettotalbutton.click();
	WebElement totaldisplay=driver.findElement(By.xpath("//div[@id='message-two']"));//display the total 
	String display=totaldisplay.getText();
	System.out.println(display);
	
	/*driver.navigate().to("https://selenium.qabible.in/check-box-demo.php");  //use navigate to move to another page
	WebElement checkbox=driver.findElement(By.xpath("//label[@class='form-check-label']"));
	boolean ischeckboxselected=checkbox.isSelected(); //for checking whether enabled the check box or not
	System.out.println(ischeckboxselected);*/
	
	}
	public void test() 
	{
	WebElement showmessagebutton=driver.findElement(By.id("button-one"));//locate the feild
	String actualbackgroundcolor=showmessagebutton.getCssValue("background-color");
	System.out.println(actualbackgroundcolor);
	String expectedresult="rgba(0, 116, 240, 1)";
	if(actualbackgroundcolor.equalsIgnoreCase(expectedresult))
	{
		System.out.println("Test Passed....");
	}
	else
	{
		System.out.println("Test Failed...");
	}
    }

	public static void main(String[] args) {
		WebelementCommands locators=new WebelementCommands();
		locators.initialiseBrowser();
		//locators.locators();
		locators.elementCommands();
		//locators.locatorsDemo();
		locators.test();
		//locators.driverQuit();
	}

}
