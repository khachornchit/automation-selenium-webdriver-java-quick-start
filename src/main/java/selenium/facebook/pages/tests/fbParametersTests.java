package selenium.facebook.pages.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.automation.utilities.DriverFactory;
import selenium.facebook.pages.FacebookLoginPage;

public class fbParametersTests {
	private WebDriver driver;
	private FacebookLoginPage facebookLogin;

	@BeforeClass(alwaysRun = true)
	public void setup() {
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driver.close();
	}

	@Parameters({ "language", "browserType" })
	@Test
	public void testLoginFacebook(@Optional("en") String language, @Optional("Firefox") String browserType) throws Exception {
		System.out.println("Language: " + language);
		System.out.println("Browser Type: " + browserType);
		
		driver = DriverFactory.getDriver();
		facebookLogin = PageFactory.initElements(driver, FacebookLoginPage.class);

		facebookLogin.loadPage();
		facebookLogin.loginCorrect();
	}
}
