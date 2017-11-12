package selenium.facebook.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.automation.utilities.BasePage;

public class FacebookMainPage extends BasePage {
	private static final String accountName = "Kokoszka";

	@FindBy(css = "._2s25>span") WebElement labelAccountName;
	@FindBy(xpath = ".//*[@id='userNavigationLabel']") WebElement buttonLogoutMenu;	
	@FindBy(css = "._54nf") WebElement navMenu;	
	@FindBy(xpath = ".//*[@class='_54nf']/li[1]/a") WebElement menuCreatePage;
	@FindBy(xpath = ".//*[@class='_54nf']/li[3]/a") WebElement menuCreateGroup;
	@FindBy(xpath = ".//*[@class='_54nf']/li[4]/a") WebElement menuManageGroup;
	@FindBy(xpath = ".//*[@class='_54nf']/li[6]/a") WebElement menuCreateAds;
	@FindBy(xpath = ".//*[@class='_54nf']/li[7]/a") WebElement menuAdonFb;
	@FindBy(xpath = ".//*[@class='_54nf']/li[9]/a") WebElement menuActivityLog;
	@FindBy(xpath = ".//*[@class='_54nf']/li[10]/a") WebElement menuNfPreferences;
	@FindBy(xpath = ".//*[@class='_54nf']/li[11]/a") WebElement menuSettings;	
	@FindBy(xpath = ".//*[@class='_54nf']/li[12]/a") WebElement menuLogout;

	public FacebookMainPage(WebDriver driver) {
		super(driver);
		this.pageTitle = "Facebook";
		this.pageUrl = "https://www.facebook.com/";
	}

	public void logout() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='userNavigationLabel']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("._54nf")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='_54nf']/li[12]/a")));		
				
		Actions action = new Actions(driver);
		int index[] = { 1,3,4,6,7,9,10,11,12 };
		for (int i = 0; i < 9; i++) {
			WebElement element = driver.findElement(By.xpath(String.format(".//*[@class='_54nf']/li[%s]/a", index[i])));	
			action.moveToElement(element).build().perform();
			Thread.sleep(1000L);
		}				
		
		action.click().build().perform();
	}

	@Override
	public void loadPage() {
		wait.until(ExpectedConditions.elementToBeClickable(labelAccountName));
		Assert.assertEquals(labelAccountName.getText(), accountName);
	}
	
	public void testAccountName() {
		wait.until(ExpectedConditions.elementToBeClickable(labelAccountName));
		Assert.assertEquals(labelAccountName.getText(), accountName);
		System.out.println(String.format("Test account name [%s] is correct.", accountName));
	}
}