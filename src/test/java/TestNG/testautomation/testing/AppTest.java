package TestNG.testautomation.testing;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	@Parameters("testNG")
	public void test(String test2) {
		if (System.getenv("jenkins") != null) {
			String test = System.getenv("jenkins");
			System.out.println(test);
		}
		System.out.println("Parameter : "+test2);
		assert Boolean.TRUE;
	}

}
