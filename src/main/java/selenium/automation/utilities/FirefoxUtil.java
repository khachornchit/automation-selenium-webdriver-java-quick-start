package selenium.automation.utilities;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FirefoxUtil {
	private static final long implicitTimeoutDefault = 5;
	private static final long pageLoadTimeoutDefault = 60;
//	private static final long fluentTimeoutDefault = 10;
//	private static final long fluentPollingTimeDefault = 1;

	private static String driverName = "webdriver.gecko.driver";
	private static String DriverPathName;
	public static long implicitTimeout;
	public static long pageLoadTimeout;
	
	public static WebDriver driver;
	public Wait<WebDriver> wait;

	public Wait<WebDriver> getWait() {
		return wait;
	}

//	public static WebDriver FirefoxUtil(String driverPathName, long implicitTimeout, long pageLoadTimeout) {
//		this.driverPathName = driverPathName;
//		this.implicitTimeout = implicitTimeout;
//		this.pageLoadTimeout = pageLoadTimeout;
//
//		System.setProperty(driverName, driverPathName);
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(this.implicitTimeout, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(this.pageLoadTimeout, TimeUnit.SECONDS);
////		driver.get(this.url);
////		Configuration(driver, fluentTimeoutDefault, fluentPollingTimeDefault);
//	}

	public static WebDriver getDriver(String DriverPathName) {
		FirefoxUtil.DriverPathName = DriverPathName;
		System.setProperty(driverName, FirefoxUtil.DriverPathName);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(implicitTimeoutDefault, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeoutDefault, TimeUnit.SECONDS);
//		Configuration(driver, fluentTimeoutDefault, fluentPollingTimeDefault);
		
		return driver;
	}
	
	public void Configuration(WebDriver driver, long timeout, long pollingTime) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(pollingTime, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}

	public WebElement FindElement(final String selector) {
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector(selector));
			}
		});
		return element;
	}

	public List<WebElement> FindElements(final String selector) {
		List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(By.cssSelector(selector));
			}
		});
		return elements;
	}
	
	public WebElement FindElementByXpath(final String xpath) {
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpath));
			}
		});
		return element;
	}
	
	public List<WebElement> FindElementsByXpath(final String xpath) {
		List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(By.xpath(xpath));
			}
		});
		return elements;
	}

	protected void finalize() {
		driver.quit();
	}
}