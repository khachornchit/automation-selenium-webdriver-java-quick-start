package selenium.youtube.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

	public static void main(String[] args) {
		String systemKey = "webdriver.gecko.driver";
		String systemValue = "C:\\SeleniumDriver\\geckodriver_v016.exe";
		System.setProperty(systemKey, systemValue);		
		WebDriver driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get("http://www.youtube.com");
		
		WebElement searchTerm = driver.findElement(By.name("search_query"));
		searchTerm.sendKeys("Body Slam");
		driver.findElement(By.id("search-btn")).click();		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		System.out.println("Start get element and printout ....");
		String xp = ".//*[@id='item-section-743182']/li[1]/div/div/div[2]/h3/a";
		String text = driver.findElement(By.xpath(xp)).getAttribute("innerHTML");
		System.out.println(text);
		System.out.println("...");
		
		driver.quit();
	}
}