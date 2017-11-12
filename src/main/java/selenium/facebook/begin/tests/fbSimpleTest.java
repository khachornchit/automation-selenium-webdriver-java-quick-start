package selenium.facebook.begin.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fbSimpleTest {

	public static void main(String[] args) throws InterruptedException {
		String systemKey = "webdriver.gecko.driver";
		String systemValue = "C:\\SeleniumDriver\\geckodriver_v016.exe";
		String url = "http://www.facebook.com";
		
		System.setProperty(systemKey, systemValue);		
		WebDriver driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get(url);
		
		WebElement textBoxUserName = driver.findElement(By.cssSelector("#email"));
		textBoxUserName.sendKeys("0843786694");
		
		WebElement forgotLink = driver.findElement(By.cssSelector(".login_form_label_field>div>a"));
		forgotLink.click();
		
		Thread.sleep(2000L);
		
		driver.quit();
	}
}
