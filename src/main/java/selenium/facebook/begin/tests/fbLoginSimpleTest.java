package selenium.facebook.begin.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import selenium.automation.utilities.FirefoxUtil;
import selenium.facebook.elements.*;

public class fbLoginSimpleTest {
	public WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = FirefoxUtil.getDriver("C:\\SeleniumDriver\\geckodriver_v016.exe");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@BeforeMethod

	@AfterMethod

	@Test
	public void loadPage() {
		String expected = "Facebook - เข้าสู่ระบบหรือสมัครใช้งาน";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}

	@Test(dependsOnMethods="loadPage")
	public void filloutEmailField() {
		String strInput = "clbsqatester@gmail.com";
		WebElement inpField = driver.findElement(By.cssSelector(elFacebookLogin.cssEmail));
		inpField.sendKeys(strInput);

		String expected = strInput;
		String actual = inpField.getAttribute("value");
		Assert.assertEquals(expected, actual);
	}
	
	@Test(dependsOnMethods="loadPage")
	public void filloutPasswordField() {
		String strInput = "clbs1234";
		WebElement inpField = driver.findElement(By.cssSelector(elFacebookLogin.cssPassword));
		inpField.sendKeys(strInput);

		String expected = strInput;
		String actual = inpField.getAttribute("value");
		Assert.assertEquals(expected, actual);
	}
}
