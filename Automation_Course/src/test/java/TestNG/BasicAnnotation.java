package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

public class BasicAnnotation {
  @Test
  public void testcase01() {
	  System.out.println("Test case 1");
  }
  @Test
  public void testcase02() {
	  System.out.println("Test case 2");
  }
  @Test
  public void testcase03() {
	  System.out.println("Test case 3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class");  
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("After class");  
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");  
  }
  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");  
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");  
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");  
  }
  
}
