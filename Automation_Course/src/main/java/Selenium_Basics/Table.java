package Selenium_Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table extends Base {

	public void tableactions() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement printtable=driver.findElement(By.xpath("//table[@id='dtBasicExample']"));//for printing all elements in the table
		System.out.println("Full Table is "+printtable.getText());
	}
	public void headings() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement tableheadings=driver.findElement(By.xpath("//table[@id='dtBasicExample']//thead"));//for prining the headings only--t head
		System.out.println("Table Headings is "+tableheadings.getText());
	}
	public void selectrow() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement row3=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tbody/tr[3]"));//for prining the rows--t body and using index
		System.out.println("3 rd Row is "+row3.getText());
	}
	public void selectanelement() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		WebElement element=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tbody//tr[1]//td[2]"));//for printing an element
		System.out.println("The Element is "+element.getText());
	}
	public void list() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		List<WebElement> positionslist=driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[2]"));//using for loop to print
		for(WebElement lists:positionslist)
		{
			System.out.println(lists.getText());
		}
	}
	public void elementsearch() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		String input="Garrett Winters";
		List<WebElement> searchname=driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
		int flag=0;
		for(WebElement lists:searchname)
		{
			if(lists.getText().equalsIgnoreCase(input))
			{
				System.out.println(lists.getText());
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println("Element Found");
		}
		else
		{
			System.out.println("Element not Found");
		}
		
	}
	public static void main(String[] args) {
		Table table=new Table();
		table.initialiseBrowser();
		table.tableactions();
		table.headings();
		table.selectrow();
		table.selectanelement();
		table.list();
		table.elementsearch();
		//table.driverQuit();

	}

}
