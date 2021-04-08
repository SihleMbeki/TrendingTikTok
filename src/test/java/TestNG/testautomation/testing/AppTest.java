package TestNG.testautomation.testing;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class AppTest extends Base {

	@Test
	@Parameters("testNG")
	public void test(String test2) throws IOException {
		driver.setup();
		//WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
		if (System.getenv("jenkins") != null) {
			String test = System.getenv("jenkins");
			System.out.println(test);
		}
		
		test.log(Status.PASS, test2);
		test.pass("String",MediaEntityBuilder.createScreenCaptureFromPath(driver.takeScreenShot()).build());
		System.out.println("Parameter : " + test2);
		log.debug("This is a debug log");
		log.info("This is a info log");
		log.error("This is a error log");
		driver.getDriver().close();
		assert Boolean.TRUE;
	}

}
