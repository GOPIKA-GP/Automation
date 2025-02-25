package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

 public class ExcelUtility 
 {
	static FileInputStream f;	
	static XSSFWorkbook w;		
	static XSSFSheet sh;

	public static String readUsernameData(int row,int col,String sheet) throws IOException
	{
		    f=new FileInputStream(Constant.excelutility_excelfilepath);
		    w=new XSSFWorkbook(f);
			sh=w.getSheet(sheet);
			XSSFRow r=sh.getRow(row);
			XSSFCell c=r.getCell(col);
			return c.getStringCellValue();
	}
	
	public static String readPasswordData(int row,int col,String sheet) throws IOException
	{
		    f=new FileInputStream(Constant.excelutility_excelfilepath);
		    w=new XSSFWorkbook(f);
			sh=w.getSheet(sheet);
			XSSFRow r=sh.getRow(row);
			XSSFCell c=r.getCell(col);
			return c.getStringCellValue();
			
	}
	
}
