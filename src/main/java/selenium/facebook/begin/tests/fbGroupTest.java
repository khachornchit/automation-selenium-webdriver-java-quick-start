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

import selenium.automation.utilities.FirefoxUtil;
import selenium.facebook.elements.elFacebookLogin;

public class fbGroupTest {
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

	@AfterMethod

	@Test(groups = { "p1", "pageLoads" })
	public void loadPage() {
		String expected = "Facebook - เข้าสู่ระบบหรือสมัครใช้งาน";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = { "p2", "fillTest" }, dependsOnMethods = "loadPage")
	public void filloutEmailField() {
		String strInput = "clbsqatester@gmail.com";
		WebElement inpField = driver.findElement(By.cssSelector(elFacebookLogin.cssEmail));
		inpField.sendKeys(strInput);

		String expected = strInput;
		String actual = inpField.getAttribute("value");
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = { "p2", "fillTest" }, dependsOnMethods = "filloutEmailField")
	public void filloutPasswordField() {
		String strInput = "clbs1234";
		WebElement inpField = driver.findElement(By.cssSelector(elFacebookLogin.cssPassword));
		inpField.sendKeys(strInput);

		String expected = strInput;
		String actual = inpField.getAttribute("value");
		Assert.assertEquals(expected, actual);
	}
}
