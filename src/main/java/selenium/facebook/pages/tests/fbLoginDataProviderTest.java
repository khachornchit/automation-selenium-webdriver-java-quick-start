package selenium.facebook.pages.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.automation.dataprovider.FacebookDataProvider;
import selenium.automation.utilities.DriverFactory;
import selenium.facebook.pages.FacebookLoginError;
import selenium.facebook.pages.FacebookLoginPage;
import selenium.facebook.pages.FacebookMainPage;
import selenium.facebook.pages.FacebookSignupPage;

public class fbLoginDataProviderTest {
	public WebDriver driver;
	private FacebookLoginPage fbLogin;
	private FacebookLoginError fbLoginError;
	private FacebookMainPage fbMainPage;
	private FacebookSignupPage fbSignupPage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		driver = DriverFactory.getDriver();
		fbLogin = PageFactory.initElements(driver, FacebookLoginPage.class);
		fbSignupPage = PageFactory.initElements(driver, FacebookSignupPage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
	}

	@Test(dataProviderClass = FacebookDataProvider.class, dataProvider = "login")
	public void testLoginFacebook(String email, String password, String valid) {			
		fbLogin.loadPage();
		fbLogin.setTextEmail(email);
		fbLogin.setTextPassword(password);

		if (valid.equals(FacebookDataProvider.valid)) {
			fbMainPage = fbLogin.loginCorrect();
			fbMainPage.loadPage();
		}
		
		else {
			fbLoginError = fbLogin.loginInvalid();
			fbLoginError.testValidationEmail();
		}
	}
	
	@Test 
	public void testSignupPage() {
		fbSignupPage.loadPage();
		fbSignupPage.fillSignup();
	}
}
