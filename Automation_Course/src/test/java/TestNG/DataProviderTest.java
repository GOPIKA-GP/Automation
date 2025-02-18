package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
  @Test(dataProvider="dataprovider1")
  public void testcase1(int a,int b) {
	  System.out.println(a+b);
  }
  @DataProvider(name="dataprovider1")
  public Object[][] dpmethod(){
	  return new Object[][] 
	{{2,10},{3,6},{6,7},{4,8}};
  }
 
}
