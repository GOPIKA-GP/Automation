package Selenium_Basics;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropDown extends Base {

 public void handlingDropDown()
 {
	driver.navigate().to("https://selenium.qabible.in/select-input.php");
	
	
	       ///selection in single dropdown list///
	WebElement singledropdown=driver.findElement(By.xpath("//select[@id='single-input-field']"));//locate webelement
	Select selectfromsingledropdown=new Select(singledropdown);//creates a Select object that can be used to interact with the dropdown.
	
	selectfromsingledropdown.selectByIndex(2);// Select the option by index (index starts from 0)
	WebElement element=selectfromsingledropdown.getFirstSelectedOption(); //After selecting the index, it retrieves the selected option using getFirstSelectedOption()
	System.out.println(element.getText());// Print the text of the selected option
	
	selectfromsingledropdown.selectByValue("Red"); //select using the attribute value--<option value="Red">
	WebElement element1=selectfromsingledropdown.getFirstSelectedOption();// Get the first selected option
	System.out.println(element1.getText());
	
	selectfromsingledropdown.selectByVisibleText("Green");//select the visible text -<option value="Green">Green</option>.b/w <option value="Green"> and </option>
	WebElement element2=selectfromsingledropdown.getFirstSelectedOption();// Get the first selected option
	System.out.println(element2.getText());
	
	
	           ///selection in multiple select list///
	WebElement multiselected=driver.findElement(By.xpath("//select[@id='multi-select-field']"));//locate webelement
	Select selectfrommultipleselectdropdown=new Select(multiselected);//creates a new Select object, which is used to interact with the dropdown
	
	boolean ismultiselected=selectfrommultipleselectdropdown.isMultiple(); //isMultiple() method checks if the dropdown allows multiple selections (i.e., if the multiple attribute is present on the <select> element).
	System.out.println(ismultiselected);
	selectfrommultipleselectdropdown.selectByIndex(0);//selects the option at index 0 in the multi-select dropdown
	selectfrommultipleselectdropdown.selectByIndex(2);//selects the option at index 2 in the multi-select dropdown
	/*for(int i=0;i<2;i++)
	{
		selectfrommultipleselectdropdown.selectByIndex(i); //for selecting i no.of elements by using index
	}*/
	List<WebElement> selectedelementlist=selectfrommultipleselectdropdown.getAllSelectedOptions();//Since more than 1 option.need to store in list.The getAllSelectedOptions() method retrieves all selected options in the dropdown and stores them in a List<WebElement>
	for(int i=0;i<selectedelementlist.size();i++)//This loops through the list of selected options 
	{
		System.out.println(selectedelementlist.get(i).getText());//prints the visible text of each selected option to the console.
	}
	//selectfrommultipleselectdropdown.deselectAll();
 }
	public static void main(String[] args) {
		dropDown dropdown=new dropDown();
		dropdown.initialiseBrowser();
		dropdown.handlingDropDown();
		//dropdown.driverQuit();
		
		
	}

}
