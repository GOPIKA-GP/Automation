package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderDemo {
  @Test(dataProvider = "dp1")
  public void testcase1(Integer n, String s) {
	  System.out.println("What is your name : "+s);
	  System.out.println("How old are you : "+n);
  }
  @Test(dataProvider = "dp2")
  public void testcase2(float a, float b) {
	  System.out.println("What is your height : "+ a +" cm"); 
	  System.out.println("What is your weight : "+ b+" kg");
  }

  @DataProvider
  public Object[][] dp1() {
    return new Object[][] 
      {{ 4, "Aditi" }}; 
  }
  
  @DataProvider
  public Object[] dp2() {
    return new Object[][]
      {{90.5f,19.5f}};
  }
  
   @Test(dataProvider="dataproviderfordemo",dataProviderClass=BasicTestCase.class)//for getting values from another class in test from a data provider
   public void testcase55(int x,String y) 
   {
	   System.out.println(y+x);
   }
      
}
