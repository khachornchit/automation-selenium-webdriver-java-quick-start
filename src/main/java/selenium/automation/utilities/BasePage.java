package selenium.automation.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;	

	protected int defaltWait = 5;
	
	protected String pageUrl;
	protected String pageTitle;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, defaltWait);
	}

	public void loadPage() {
		driver.get(pageUrl);
		Assert.assertEquals(driver.getTitle(),pageTitle);
	}
	
	public void loadPage(String pageUrl, String pageTitle) {
		this.pageUrl = pageUrl;
		this.pageTitle = pageTitle;
		driver.get(pageUrl);
		Assert.assertEquals(driver.getTitle(),pageTitle);
	}
	
	public boolean verifyElementPresent(WebElement element) {
		try {
			element.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			
		}
	}

	protected void clickElement(WebElement element) {
		element.click();
	}

	protected void setElementText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"), text);
	}
}
