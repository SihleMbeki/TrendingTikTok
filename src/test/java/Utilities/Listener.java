package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import TestNG.testautomation.testing.Base;

public class Listener extends Base implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		/*
		 * log.info("Test Failure"); test.log(Status.FAIL, "TEST FAILED"); if
		 * (driver.getError() != null) { test.log(Status.FAIL, driver.getError());
		 * log.debug("Test Failed: " + driver.getError()); }
		 * 
		 * try { test.pass("String",
		 * MediaEntityBuilder.createScreenCaptureFromPath(driver.takeScreenShot()).build
		 * ()); } catch (IOException e) { log.debug("Failed to take screenshot");
		 * e.printStackTrace(); }
		 */
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentTest test = ExtentReport.createTest(((ITestResult) arg0).getMethod().getMethodName());
		setTestItem(test);
		driver=new SeleniumDriver();
		driver.setup();
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		log.info("Test Success");
		getTest().log(Status.PASS, "TEST SUCCESS");
		log.debug("Test Passed");
		if (getDriver().getDriver() != null)
			getDriver().getDriver().close();
		log.info("closed the driver");
		/*
		 * try { //test.pass("String",
		 * MediaEntityBuilder.createScreenCaptureFromPath(driver.takeScreenShot()).build
		 * ()); } catch (IOException e) { log.debug("Failed to take screenshot");
		 * e.printStackTrace(); }
		 */
	}

}
