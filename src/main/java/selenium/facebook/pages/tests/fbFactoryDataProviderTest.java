package selenium.facebook.pages.tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium.automation.dataprovider.FacebookDataProvider;
import selenium.automation.utilities.DriverFactory;
import selenium.automation.utilities.TestListener;
import selenium.facebook.pages.FacebookSignupPage;

@Listeners(TestListener.class)
public class fbFactoryDataProviderTest {
	private WebDriver driver;
	private FacebookSignupPage fbSignupPage;
	HashMap<String, String> signUpMap;
	
	@Factory(dataProviderClass = FacebookDataProvider.class, dataProvider = "signup")
	public fbFactoryDataProviderTest(String firstName, String lastName, String email, String bDay, String bMonth, String bYear)
	{
		signUpMap = new HashMap<String, String>();
		signUpMap.put("firstName", firstName);
		signUpMap.put("lastName", lastName);
		signUpMap.put("email", email);
		signUpMap.put("bDay", bDay);
		signUpMap.put("bMonth", bMonth);
		signUpMap.put("bYear", bYear);		
	}

	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		driver = DriverFactory.getDriver();
		fbSignupPage = PageFactory.initElements(driver, FacebookSignupPage.class);
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driver.close();
	}
	
	@Test
	public void testSignup() {
		fbSignupPage.loadPage();
		fbSignupPage.fillSignup(
				signUpMap.get("firstName"), 
				signUpMap.get("lastName"), 
				signUpMap.get("email"), 
				signUpMap.get("bDay"), 
				signUpMap.get("bMonth"), 
				signUpMap.get("bYear"));		
	}	
}
