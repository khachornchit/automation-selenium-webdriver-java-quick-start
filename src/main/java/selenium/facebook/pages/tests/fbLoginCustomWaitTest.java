package selenium.facebook.pages.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.automation.utilities.DriverFactory;
import selenium.facebook.pages.FacebookLoginPageCustomWait;

public class fbLoginCustomWaitTest {
	private WebDriver driver;
	private FacebookLoginPageCustomWait facebookLogin;

	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		driver = DriverFactory.getDriver();
		facebookLogin = PageFactory.initElements(driver, FacebookLoginPageCustomWait.class);
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driver.close();
	}

	@Test
	public void testLoginFacebook() {
		facebookLogin.loadPage();
		facebookLogin.loginCorrect();
	}
}
