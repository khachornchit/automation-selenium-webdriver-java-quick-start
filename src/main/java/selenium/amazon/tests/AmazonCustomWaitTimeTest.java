package selenium.amazon.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import selenium.automation.utilities.WaitUtilities;

public class AmazonCustomWaitTimeTest {

	public static void main(String[] args) {
		String systemKey = "webdriver.gecko.driver";
		String systemValue = "C:\\SeleniumDriver\\geckodriver_v016.exe";
		String url = "https://www.amazon.com/";

		System.setProperty(systemKey, systemValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		
		final String selector = "#nav-link-accountList";
		final int timeout = 5;
		final int pollingTime = 1;
		
		WaitUtilities.Configuration(driver, timeout, pollingTime);
		
		try {
			WebElement element = WaitUtilities.FindElement(selector);
			element.click();

			System.out.println(String.format("Wait Utitlities Successful: Found and clickable : %s", selector) );
		} catch (Exception e) {
			System.out.println(String.format("Wait Utitlities Timeout !!! find not found : %s !", selector) );
		}
		
		driver.quit();
	}

}
