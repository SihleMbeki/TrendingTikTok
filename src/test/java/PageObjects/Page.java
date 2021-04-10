package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	public Page(WebDriver driver,Page page) {
		PageFactory.initElements(driver,page);
	}

}
