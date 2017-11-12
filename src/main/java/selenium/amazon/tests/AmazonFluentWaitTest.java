package selenium.amazon.tests;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AmazonFluentWaitTest {

	public static void main(String[] args) {
		String systemKey = "webdriver.gecko.driver";
		String systemValue = "C:\\SeleniumDriver\\geckodriver_v016.exe";
		String url = "https://www.amazon.com/";

		System.setProperty(systemKey, systemValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds (for custom setting).
		// Polling time is 500 ms by default and able to define custom polling time.
		// Timeout is 500 milliseconds by default and able to define custom timeout.

		final String selector = "#nav-link-accountListx";
		final int timeout = 5;
		final int pollingTime = 1;
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(pollingTime, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		try {
			WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(selector));
				}
			});		
			element.click();

			System.out.println(String.format("Successful: Found and clickable : %s", selector) );
		} catch (Exception e) {
			System.out.println(String.format("FluentWait Timeout!!! find not found : %s !", selector) );
		}
		
		driver.quit();
	}	
}
