package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationcore.BaseClass;
import utilities.ExtendReportUtility;

public class Listeners extends BaseClass implements ITestListener // we are calling here the extend report utility
{
	ExtentTest test; // represents a single test in the report.
	ExtentReports extent = ExtendReportUtility.createExtentReports();// calling create extend reports from the
																		// ExtendReport utility
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// for ensure thread safety for parallel
																		// testing/running

	public void onTestStart(ITestResult result) // over-riding interface -method from ITest Listener
												// it is called/invoke when a test starts
	{
		ITestListener.super.onTestStart(result); // using super keyword invoking method from parent
		test = extent.createTest(result.getMethod().getMethodName()); // Retrieving test method
		extentTest.set(test); // creates extend report test
	}

	public void onTestSuccess(ITestResult result) // call when a test is success
	{
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");// log status and print
	}

	public void onTestFailure(ITestResult result) // call when a test fails
	{
		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");// log status and print
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try // try-catch for handling various exceptions
		{
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) // Called when a test is skipped.
	{
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");// log status and print
		// String testMethodName = result.getMethod().getMethodName();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) // call when test is failed but meeting the
																			// defined success percentage
	{
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result)// called when test case fails due to timeout
	{
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) // called at the start of a test context
	{
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) // called at the end of test case
	{
		ITestListener.super.onFinish(context);
		extent.flush(); // save and write all collected logs and test details into the final report
	}
}