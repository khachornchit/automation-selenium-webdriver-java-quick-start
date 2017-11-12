package selenium.amazon.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selenium.amazon.elements.elAmazon;
import selenium.automation.utilities.FirefoxUtil;

public class AmazonFirefoxUtilTest {

	public static void main(String[] args) {
		WebDriver driver = FirefoxUtil.getDriver("C:\\SeleniumDriver\\geckodriver_v016.exe");

		try {
			System.out.println(String.format("URL : %s", driver.getCurrentUrl()));
			System.out.println(String.format("Title : %s", driver.getTitle()));
			
			WebElement navAccountList = driver.findElement(By.cssSelector(elAmazon.NavAccountList));
			navAccountList.click();
			
			WebElement navDepartment = driver.findElement(By.cssSelector(elAmazon.NavDepartmentName));
			Actions action = new Actions(driver);
			
			action.moveToElement(navDepartment).build().perform();			
			List<WebElement> navList = driver.findElements(By.cssSelector(elAmazon.NavDepartmentContentName));

			for (WebElement webElement : navList) {
				System.out.println(webElement.getText());
			}
			
			navAccountList.click();
			
			System.out.println(String.format("Firefox Util Test Successful: Found and clickable : %s",
					elAmazon.NavAccountList));
		} catch (Exception e) {
			System.out.println(
					String.format("Firefox Util Test Timeout !!! find not found : %s !", elAmazon.NavAccountList));
		}

		driver.quit();
	}

}
