package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTestCase {
  @Test(priority=-3)
  public void testcase81() {
	  System.out.println("Test Case 1");
  }
  @Test(priority=1,enabled=false)//will not work if enabled=false, will work when enabled =true
  public void testcase2() {
	  System.out.println("Test Case 2");
  }
  @Test(priority=1,groups="smoke")
  public void testcase3() {
	  System.out.println("Test Case 3");
  }
  @Test(priority=-2,enabled=true)
  public void testcase6() {
	  System.out.println("Test Case 4");
  }
  @Test(priority=0,groups="smoke")//no priority will set as 0 priority//wring include ingrop xml file will include smoke name testcase and excled will excle those test cases
  public void testcase5() {
	  System.out.println("Test Case 5");  
  }
  
  @Test(priority=-8,groups="smoke")
  public void testcase7() {
	  System.out.println("Test Case 7");  
  }
  @DataProvider(name="dataproviderfordemo")
  public Object[][] dp() {
    return new Object[][] 
      {{ 4, "Aditi" }}; 
  }
}
