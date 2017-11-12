package selenium.amazon.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import selenium.automation.utilities.WaitUtilities;

public class AmazonRetreiveNavItems {

	public static void main(String[] args) {
		String systemKey = "webdriver.gecko.driver";
		String systemValue = "C:\\SeleniumDriver\\geckodriver_v016.exe";
		String url = "https://www.amazon.com/";

		System.setProperty(systemKey, systemValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);

		final String navDepartmentName = ".nav-line-2";
		final String navDepartmentContentName = ".nav-template.nav-flyout-content.nav-tpl-itemList";

		WebElement navDepartment = driver.findElement(By.cssSelector(navDepartmentName));
		Actions action = new Actions(driver);
		action.moveToElement(navDepartment).build().perform();

		System.out.println("Using Wait Utilities");
		WaitUtilities.Configuration(driver, 10, 1);
		List<WebElement> navButtons = WaitUtilities.FindElements(navDepartmentContentName);

		for (WebElement webElement : navButtons) {
			System.out.println(webElement.getText());
		}

		driver.quit();
	}

}
