package selenium.automation.utilities;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitUtilities {
	private final static int fluentTimeoutDefault = 10;
	private final static int fluentPollingTimeDefault = 1;
	
	private static Wait<WebDriver> wait;
	
	public static void Configuration(WebDriver driver) {
		int timeout = fluentTimeoutDefault;
		int pollingTime = fluentPollingTimeDefault;
		
		wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(pollingTime, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}

	public static void Configuration(WebDriver driver, int timeout, int pollingTime) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(pollingTime, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}

	//By cssSelector
	public static WebElement FindElement(final String selector) {
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector(selector));
			}
		});
		return element;
	}

	public static List<WebElement> FindElements(final String selector) {
		List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(By.cssSelector(selector));
			}
		});
		return elements;
	}
	
	//By xpath
	public static WebElement FindElementByXpath(final String xpath) {
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpath));
			}
		});
		return element;
	}

	public static List<WebElement> FindElementsByXpath(final String xpath) {
		List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(By.xpath(xpath));
			}
		});
		return elements;
	}
}
