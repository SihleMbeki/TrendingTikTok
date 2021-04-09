package TestNG.testautomation.testing;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReport;
import Utilities.SeleniumDriver;

public class Base {
	ExtentTest test;
	SeleniumDriver driver;
	PrintWriter writer=null;
	public static Logger log = Logger.getLogger(Base.class);
	@BeforeSuite
	public void suiteSetup() {
		driver=new SeleniumDriver();
		DOMConfigurator.configure("log4j.xml");
		BasicConfigurator.configure();
		ExtentReport.foldername();
		ExtentReport.createExtentReports();
		try {
			writer=new PrintWriter(ExtentReport.getDirectory()+"/testData.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setTest(Method testMethod) {
		test = ExtentReport.createTest(testMethod.getName());
	}

	@AfterSuite
	public void teardown() {
		ExtentReport.closeReport();
		writer.close();
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
