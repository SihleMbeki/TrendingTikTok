package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestNG.testautomation.testing.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	private WebDriver driver;
	private String error=null;

	public void setup() {
		try {
			Duration tenSeconds = Duration.ofSeconds(10);
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			//options.setExperimentalOption("debuggerAddress","localhost:9222");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(tenSeconds);

		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	// wait for presence of element
	public void waitForElement(String cssXpath) {
		try {
			Duration threeseconds = Duration.ofMillis(1000);
			WebDriverWait wait = new WebDriverWait(driver, threeseconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cssXpath)));
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// wait for clickable of element
	public void waitForElementClickable(String cssXpath) {
		try {
			Duration threeseconds = Duration.ofMillis(1000);
			WebDriverWait wait = new WebDriverWait(driver, threeseconds);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cssXpath)));
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// accept alert
	public void acceptAlert() {
		try {
			Duration threeseconds = Duration.ofMillis(300);
			WebDriverWait wait = new WebDriverWait(driver, threeseconds);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// press Enter
	public void pressEnter() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// select dropdown
	public void selectDropdown(WebElement select, String option) {
		try {
			Select selection = new Select(select);
			selection.selectByVisibleText(option);
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// switch to window
	public void nextTab() {
		try {
			Set winids = driver.getWindowHandles();
			Iterator iterate = winids.iterator();
			driver.switchTo().window(iterate.next().toString());
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// Switch to default
	public void switchToFrame(String name) {
		try {
			driver.switchTo().frame(name);
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// Switch to default content
	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	// Click via JS
	public void clickJS(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
		}
	}

	//Take Screenshot
	public String takeScreenShot() {
		String screenshotFile;
		try {
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
			screenshotFile=ExtentReport.getDirectory()+"//screenshot//"+fileName;
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotFile));
			return screenshotFile;
		} catch (Exception e) {
			error = e.getMessage();
			Base.log.error(error);
			Assert.fail();
			return null;
		}
	}
	
	public String getError() {
		return error;
	}


}
