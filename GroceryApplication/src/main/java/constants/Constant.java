package constants;

public class Constant {
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	public static final String excelutility_excelfilepath=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
	public static final String ImagePath1=System.getProperty("user.dir") + "\\src\\test\\resources\\images\\FASHION.jpg";
	public static final String ImagePath2=System.getProperty("user.dir") + "\\src\\test\\resources\\images\\icecream.jpg";
	public static final String ImagePath3=System.getProperty("user.dir")+"\\src\\test\\resources\\images\\softtoys.jpg";
	public static final String screenshotutility_screenshot_filepath=System.getProperty("user.dir") + "\\OutputScreenshots\\";
	
	public static final String lp_alertmessage="Aleart message is not expected";
    public static final String lp_loginfailwarning="Login attempt fails";
    
    public static final String au_failAlert="User Creation Fails";
    public static final String au_SearchData="Username Aditi is not found";
    
    public static final String ctgy_AlertMessage1="Category is not Created";
    public static final String ctgy_AlertMessage2="Category Status is not Changed";
    public static final String ctgy_NotFoundAlert=".........RESULT NOT FOUND.......";
    
    public static final String mc_FailAlert="Contact Updated Fails";
    
    public static final String sc_InvalidDataAlert=".........RESULT NOT FOUND.......";
    public static final String sc_AlertMaessage1="Sub Category Creation Fails";
    public static final String sc_AlertMaessage2="Sub Category Updation Fails";
    
    public static final String mn_FailAlert="News creation fails";
    public static final String mn_searchResult="No news found";
}
