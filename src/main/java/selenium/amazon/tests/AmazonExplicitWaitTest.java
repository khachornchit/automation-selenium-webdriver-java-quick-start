package selenium.amazon.tests;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonExplicitWaitTest {

	public static void main(String[] args) throws IOException {
		String systemKey = "webdriver.gecko.driver";
		String systemValue = "C:\\SeleniumDriver\\geckodriver_v016.exe";
		String url = "https://www.amazon.com/";

		System.setProperty(systemKey, systemValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		
		// Waiting 10 seconds for element to be present in the pages,
		// checking for its presence once every 500 ms.
		// Polling time is 500 ms by default and unable to define custom polling time.
		// There is no default timeout for explicit wait and have to define custom time out.

		final String selector = "#nav-link-accountListx";
		final int timeout = 5;
		
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
				.ignoring(NoSuchElementException.class);
				
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));		
			element.click();
			
			System.out.println(String.format("Successful: Found and clickable : %s", selector) );
		} catch (Exception e) {
			
			System.out.println(String.format("Explicit Wait Timeout !!! find not found : %s !", selector) );
		}
		
		driver.quit();
	}
}
