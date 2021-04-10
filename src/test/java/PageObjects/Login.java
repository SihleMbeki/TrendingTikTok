package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login{
	@FindBy(css = "[type='email']")
	WebElement username;
	
	@FindBy(css = "#identifierNext button")
	WebElement next;
	
	/*
	 * 
 @FindBys({
 @FindBy(class="custom-control-check-box"),
 @FindBy(id="game-chk-box")
}) 
WebElement chkBox;*/
	
	/*
	 * 
@FindAll({
 @FindBy(id="btn", //doesn't match
 @FindBy(name="sbmtBtn"), //Matches
 @FindBy(class="btn-primary") //doesn't match
})

@FindAll({
 @FindBy(id="btn", //doesn't match
 @FindBy(name="sbmtBtn"), //Matches
 @FindBy(class="btn-primary") //doesn't match
})
 
@CacheLookUp
@FindBys({
 @FindBy(class="custom-control-check-box"),
 @FindBy(id="game-chk-box") 
})
 
WebElement chkBox;

id, name, className, css, tagName, linkText, partialLinkText, xpath
driver.findElement(By.name(“user_password”)).sendKeys(password);

@FindBys(@FindBy(css=”div[class=’yt-lockup-tile yt-lockup-video’]”)))
private List<WebElement> videoElements;

@FindBy(how = How.LINK_TEXT, using = "APPLY AS A DEVELOPER")
   private WebElement developerApplyButton;
   
   @FindBy(how=How.CSS,using="div[class=’yt-lockup-tile yt-lockup-video’]")
private List<WebElement> videoElements;
*/

	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	//	super(driver,this);
    //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	public void submitUsername(String email) {
		username.sendKeys(email);
		next.click();
	}

}
