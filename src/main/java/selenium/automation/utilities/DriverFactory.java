package selenium.automation.utilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	public enum BrowserType {
		FIREFOX("firefox"), CHROME("chrome"), IE("internet_explorer"), SAFARI("safari");

		private String value;

		BrowserType(String value) {
			this.value = value;
		}

		public String getBrowserName() {
			return this.value;
		}
	}

	private static final long implicitTimeoutDefault = 20;
	private static final long pageLoadTimeoutDefault = 60;

	private static String driverFirefox = "webdriver.gecko.driver";
	private static String driverChrome = "webdriver.chrome.driver";
	private static String driverIE = "webdriver.ie.driver";

	private static String driverPathNameFirefox = "C:\\SeleniumDriver\\geckodriver_v016.exe";
	private static String driverPathNameChrome = "C:\\SeleniumDriver\\chromedriver.exe";
	private static String driverPathNameIE = "C:\\SeleniumDriver\\IEDriverServer.exe";
	private static DesiredCapabilities desiredCapabilities;

	public static WebDriver getDriver() throws Exception {
		BrowserType type = getBrowserTypeByProperty();
		if (getUseGridByProperty()) {
			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setBrowserName(type.getBrowserName());
			desiredCapabilities.setPlatform(Platform.WINDOWS);
			return new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"), desiredCapabilities);
		} else {
			return getDriverFromWebDriver();
		}
	}

	private static WebDriver getDriverFromWebDriver() throws IOException {
		BrowserType type = getBrowserTypeByProperty();
		WebDriver driver;

		switch (type) {
		case FIREFOX:
			System.setProperty(driverFirefox, driverPathNameFirefox);
			driver = new FirefoxDriver();
			break;

		case CHROME:
			System.setProperty(driverChrome, driverPathNameChrome);
			driver = new ChromeDriver();
			break;

		case IE:
			System.setProperty(driverIE, driverPathNameIE);
			driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;

		default:
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().timeouts().implicitlyWait(implicitTimeoutDefault, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeoutDefault, TimeUnit.SECONDS);
		return driver;
	}
	
	private static boolean getUseGridByProperty() throws Exception {
		PropertyManager.loadConfigProperties();
		return PropertyManager.getProperty("USE_GRID").equalsIgnoreCase("true");
	}

	private static BrowserType getBrowserTypeByProperty() throws IOException {
		BrowserType type = null;
		PropertyManager.loadConfigProperties();
		String browserName = PropertyManager.getProperty("BROWSER");
		for (BrowserType bType : BrowserType.values()) {
			if (bType.getBrowserName().equalsIgnoreCase(browserName)) {
				type = bType;
				break;
			}
		}
		return type;
	}
}
