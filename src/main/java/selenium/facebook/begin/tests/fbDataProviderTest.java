package selenium.facebook.begin.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.automation.dataprovider.FacebookDataProvider;
import selenium.automation.utilities.FirefoxUtil;
import selenium.facebook.elements.elFacebookLogin;

public class fbDataProviderTest {
	public WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = FirefoxUtil.getDriver("C:\\SeleniumDriver\\geckodriver_v016.exe");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	@BeforeMethod
	public void driverOpen() {
	}

	@AfterMethod
	public void driverClose() {
	}

	@Test(groups = { "p1", "pageLoads" })
	public void loadPage() {
		String expected = elFacebookLogin.Title;
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = { "p2", "filloutFieldTest" }, dependsOnMethods = "loadPage", dataProvider = "fields", dataProviderClass = FacebookDataProvider.class)
	public void filloutField(String elementCss, String value) {
		WebElement inpField = driver.findElement(By.cssSelector(elementCss));
		inpField.sendKeys(value);

		String expected = value;
		String actual = inpField.getAttribute("value");
		Assert.assertEquals(expected, actual);
	}
}
