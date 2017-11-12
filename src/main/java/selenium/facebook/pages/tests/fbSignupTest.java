package selenium.facebook.pages.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.automation.dataprovider.FacebookDataProvider;
import selenium.automation.utilities.DriverFactory;
import selenium.facebook.pages.FacebookSignupPage;

public class fbSignupTest {
	private WebDriver driver;
	private FacebookSignupPage fbSignupPage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		driver = DriverFactory.getDriver();
		fbSignupPage = PageFactory.initElements(driver, FacebookSignupPage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
	}

	@Test (dataProviderClass = FacebookDataProvider.class, dataProvider = "signup")
	public void testSignup(String firstName, String lastName, String email, String bDay, String bMonth, String bYear) {
		fbSignupPage.loadPage();
		fbSignupPage.fillSignup(firstName, lastName, email, bDay, bMonth, bYear);		
	}	
}