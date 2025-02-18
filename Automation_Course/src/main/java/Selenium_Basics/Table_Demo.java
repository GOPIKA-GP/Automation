package Selenium_Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table_Demo extends Base{
	public void salary() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		List<WebElement> listofsalary=driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[6]"));
		for(WebElement list:listofsalary)
		{
			System.out.println(list.getText());
		}
	}
	public void search() {
		driver.navigate().to("https://selenium.qabible.in/table-pagination.php");
		String inputforsearch="Javascript DevelopER";//not case sensitive-bot captital and small letters are accepting
		List<WebElement> searchinlist=driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr[9]//td[2]"));
		int flag=0;
		for(WebElement list:searchinlist)
		{
			if(list.getText().equalsIgnoreCase(inputforsearch))
			{
				System.out.println(list.getText());
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println("ELEMENT FOUND");
		}
		else
		{
			System.out.println("ELEMENT NOT FOUND");
		}
		
	}

	public static void main(String[] args) {
		Table_Demo tableeg=new Table_Demo();
		tableeg.initialiseBrowser();
		tableeg.salary();
		tableeg.search();
		//tableeg.driverQuit();
	}

}
