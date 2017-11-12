package selenium.facebook.pages.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.automation.utilities.DriverFactory;
import selenium.facebook.pages.FacebookLoginPage;
import selenium.facebook.pages.FacebookMainPage;

public class fbLogoutTest {
	public WebDriver driver;
	private FacebookLoginPage fbLogin;
	private FacebookMainPage fbMainPage;

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
		fbLogin.setTextEmailCorrect();
		fbLogin.setTextPasswordCorrect();
		fbMainPage = fbLogin.loginCorrect();
		fbMainPage.loadPage();
		fbMainPage.logout();		
	}
}