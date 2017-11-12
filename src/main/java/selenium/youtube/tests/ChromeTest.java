package selenium.youtube.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

	public static void main(String[] args) {
		String systemKey = "webdriver.chrome.driver";
		String systemValue = "C:\\SeleniumDriver\\chromedriver.exe";
		System.setProperty(systemKey, systemValue);		
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.youtube.com");
		
		WebElement searchTerm = driver.findElement(By.name("search_query"));
		searchTerm.sendKeys("Body Slam");
		driver.findElement(By.id("search-btn")).click();
		
		System.out.println("Start get element and printout ....");
		String xp = ".//*[@id='item-section-743182']/li[1]/div/div/div[2]/h3/a";
		String text = driver.findElement(By.xpath(xp)).getAttribute("innerHTML");
		System.out.println(text);
		System.out.println("...");
		
		driver.quit();
	}

}
