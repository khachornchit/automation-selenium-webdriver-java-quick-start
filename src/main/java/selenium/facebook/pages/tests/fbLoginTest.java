package selenium.facebook.pages.tests;

import org.testng.annotations.Test;

import selenium.automation.utilities.DriverFactory;
import selenium.facebook.pages.FacebookLoginPage;
import selenium.facebook.pages.FacebookMainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class fbLoginTest {
	private WebDriver driver;
	private FacebookLoginPage fbLogin;
	FacebookMainPage fbMainPage;

	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		driver = DriverFactory.getDriver();
		fbLogin = PageFactory.initElements(driver, FacebookLoginPage.class);
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driver.close();
	}

	@Test
	public void testLoginFacebook() throws InterruptedException {
		fbLogin.loadPage();
		fbMainPage = fbLogin.loginCorrect();
		fbMainPage.testAccountName();
	}
}