package selenium.cookie.tests;

import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junitx.util.PropertyManager;
import selenium.automation.utilities.DriverFactory;
import selenium.automation.utilities.TestListener;

@Listeners(TestListener.class)
public class CookieTest {
	private WebDriver driver;
	private WebDriverWait wait; 
	String name = "Steam_Language";
	String path = "/";
	String domain = "store.steampowered.com";
	Date someDate;
	String baseUrl;

	HashMap<String, String> languages = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("en", "english");
			put("es", "spanish");
		}
	};

	Cookie cookie1 = new Cookie(name, languages.get("en"));
	Cookie cookie2 = new Cookie(name, languages.get("en"), "/");
	Cookie cookie3 = new Cookie(name, languages.get("en"), "/", someDate);
	Cookie cookie4 = new Cookie(name, languages.get("en"), domain, "/", someDate, false);
	
	Cookie enCookie = new Cookie(name, languages.get("en"), domain, "/", someDate);
	Cookie esCookie = new Cookie(name, languages.get("es"), domain, "/", someDate);

	@BeforeClass
	public void setupCookies() throws Exception {
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, 10);
		someDate = new Date();
		someDate.setTime(System.currentTimeMillis() + 60000);
		baseUrl = "http://" + domain;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void removeCookies() {
		driver.get(baseUrl);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void addEnglishCookieTest() throws InterruptedException {
		System.out.println(String.format("PropertyManager Test [%s]", PropertyManager.getProperty("LOCATION")));
		driver.get(baseUrl);
		IsTargetCookieExisting();
		
		Cookie addedCookie = enCookie;
		driver.manage().addCookie(addedCookie);
		driver.navigate().refresh();
		IsAddedCookieSuccessful(addedCookie);
	}

	@Test
	public void addSpanishCookieTest() {			
		Cookie addedCookie = esCookie;
		driver.manage().addCookie(addedCookie);
		driver.navigate().refresh();
		IsAddedCookieSuccessful(addedCookie);
	}

	@Test
	public void deleteSpanishCookieBackToEnglishTest() {
		driver.get(baseUrl);
		IsTargetCookieExisting();
		
		Cookie addedCookie = esCookie;
		driver.manage().addCookie(addedCookie);
		driver.navigate().refresh();
		IsAddedCookieSuccessful(addedCookie);
		
		driver.manage().deleteCookieNamed(name);
		driver.navigate().refresh();
		IsTargetCookieExisting();
		
		addedCookie = enCookie;
		driver.manage().addCookie(addedCookie);
		driver.navigate().refresh();
		IsAddedCookieSuccessful(addedCookie);
	}
	
	@Test
	public void dropDownToSpanishTest() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.cssSelector("#language_pulldown")).click();
		driver.findElement(By.cssSelector("a[href='?l=spanish']")).click();
		wait.until(ExpectedConditions.textToBe(By.cssSelector("#language_pulldown"), "idioma"));
		IsAddedCookieSuccessful(esCookie);
	}
	
	private void IsTargetCookieExisting() {
		for (Cookie cookie : driver.manage().getCookies()) {
			if (cookie.getName().equals(name)) {
				Assert.fail();
			};
		}
	}
	
	private void IsAddedCookieSuccessful(Cookie addedCookie) {
		for (Cookie cookie : driver.manage().getCookies()) {
			if (cookie.getName().equals(name)) {
				Assert.assertEquals(cookie.getValue(), addedCookie.getValue());
				System.out.println(
						String.format("Added cookie name [%s] is existing. Its value is [%s] and its domain is [%s]",
								cookie.getName(), cookie.getValue(), cookie.getDomain()));
			}
		}
	}
}
