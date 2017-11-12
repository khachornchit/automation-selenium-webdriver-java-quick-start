package selenium.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FacebookPOMLogin {
	WebDriver driver;

	public final String pageUrl = "http://www.facebook.com";
	public final String pageTitle = "Facebook - เข้าสู่ระบบหรือสมัครใช้งาน";

	private final String fieldEmail = "#email";
	private final String fieldPassword = "#pass";

	public FacebookPOMLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void loadPage() {
		driver.manage().deleteAllCookies();
		driver.get(pageUrl);
		Assert.assertEquals(driver.getTitle(), pageTitle);
	}

	public void setTextEmail(String text) {
		WebElement element = driver.findElement(By.cssSelector(fieldEmail));
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"), text);
	}

	public void setTextPassword(String text) {
		WebElement element = driver.findElement(By.cssSelector(fieldPassword));
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"), text);
	}
}