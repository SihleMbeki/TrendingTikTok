package TestNG.testautomation.testing;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReport;

public class Base {
	ExtentTest test;

	@BeforeSuite
	public void suiteSetup() {
		ExtentReport.foldername();
		ExtentReport.createExtentReports();
	}

	@BeforeMethod
	public void setTest(Method testMethod) {
		test = ExtentReport.createTest(testMethod.getName());
	}

	@AfterSuite
	public void teardown() {
		ExtentReport.closeReport();
	}
	/*
	 * 
	 * @BeforeSuite
	 * 
	 * @BeforeTest
	 * 
	 * @BeforeClass
	 * 
	 * @BeforeMethod
	 * 
	 * @Test
	 * 
	 * @AfterSuite
	 * 
	 * @AfterTest
	 * 
	 * @AfterClass
	 * 
	 * @AfterMethod
	 * 
	 */
	/*
	<methods>
	<include name="searchCustomer"/>
	</methods>

	assertTrue
	assertFalse
	assertSame
	assertNotNull
	assertEquals

	SoftAssert softassert=new SoftAssert();
	softassert.assertAll();

	@Test(dependsOnMethods="test")
	@Test(dependsOnMethods={"test","test2"})
	@Test(groups="initialize")
	@Test(dependsOnGroups="test",groups="initialize")
	@Test(groups={"initialize","test"})
	<groups>
	<run>
	<include name="initialize"/>
	<exclude name="test"/>
	</groups>

	<classes>
	<class name="com..."/>
	</classes>*/

}
