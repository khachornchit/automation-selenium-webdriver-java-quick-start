package selenium.facebook.pages.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.automation.utilities.FirefoxUtil;
import selenium.facebook.pages.FacebookPOMLogin;

public class fbLoginPomTest {
	public WebDriver driver;
	private FacebookPOMLogin facebookLogin;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = FirefoxUtil.getDriver("C:\\SeleniumDriver\\geckodriver_v016.exe");
		facebookLogin = new FacebookPOMLogin(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	@Test(groups = { "p1", "pageLoads" })
	public void loadPage() {
		try {
			facebookLogin.loadPage();			
		} catch (Exception e) {
			System.out.println("Facebook loadPage() error : " + e.getMessage());
		} finally {
			System.out.println("Driver refresh.");
			driver.navigate().refresh();
		}
	}

	@Test(groups = { "p2", "fillTest" }, dependsOnMethods = "loadPage")
	public void filloutEmailField() {
		facebookLogin.setTextEmail("clbsqatester@gmail.com");
	}

	@Test(groups = { "p2", "fillTest" }, dependsOnMethods = "filloutEmailField")
	public void filloutPasswordField() {
		facebookLogin.setTextPassword("clbs1234");
	}
}
