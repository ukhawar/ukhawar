package Assignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReportNG.getReportObject();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	  test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		try {
			getScreenShots(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
        extent.flush();
	}

}
