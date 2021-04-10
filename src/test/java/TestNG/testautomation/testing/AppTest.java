package TestNG.testautomation.testing;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PageObjects.Login;

public class AppTest extends Base {

	@Test
	@Parameters("testNG")
	public void test(String test2) throws IOException {
		
		//WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
		if (System.getenv("jenkins") != null) {
			String test = System.getenv("jenkins");
			System.out.println(test);
		}
		driver.getDriver().get("https://accounts.google.com/signin/v2/identifier?service=adwords&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		Login login=new Login(driver.getDriver());
		login.submitUsername("sihle.matanzima@gmail.com");
		
		getTest().log(Status.PASS, test2);
		getTest().pass("String",MediaEntityBuilder.createScreenCaptureFromPath(driver.takeScreenShot()).build());
		writer.write("Column1,Column2");
		System.out.println("Parameter : " + test2);
		log.debug("This is a debug log");
		log.info("This is a info log");
		log.error("This is a error log");
		
		assert Boolean.TRUE;
	}

}
