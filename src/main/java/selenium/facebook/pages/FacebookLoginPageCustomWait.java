package selenium.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.automation.utilities.BasePage;
import selenium.automation.utilities.CustomWait;

public class FacebookLoginPageCustomWait extends BasePage {
	public static final String email = "clbsqatester@gmail.com";
	public static final String password = "clbs123456!@#$%^";
	
	public static final String emailIncorrect = "clbsxx@gmail.com";
	public static final String passwordIncorrect = "clbs1234";

	@FindBy(css = "#email") WebElement fieldEmail;
	@FindBy(css = "#pass") WebElement fieldPassword;
	@FindBy(css = "#loginbutton")WebElement buttonLogin;
		
	public FacebookLoginPageCustomWait(WebDriver driver) {
		super(driver);
		this.pageTitle = "Facebook - เข้าสู่ระบบหรือสมัครใช้งาน";
		this.pageUrl = "https://www.facebook.com/";
	}
	
	public void setTextEmail(String text) {
		setElementText( fieldEmail, text);
	}

	public void setTextPassword(String text) {
		setElementText(fieldPassword, text);
	}

	private void setTextEmailCorrect() {
		setElementText(fieldEmail, email);
	}

	private void setTextPasswordCorrect() {
		setElementText(fieldPassword, password);
	}
	
	public FacebookMainPage loginCorrect() {
		wait.until(CustomWait.visibilityOfElement(buttonLogin));
		System.out.println("Custom wait work successfully!");
//		wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
		setTextEmailCorrect();
		setTextPasswordCorrect();
		buttonLogin.click();
		return PageFactory.initElements(driver, FacebookMainPage.class);
	}
	
	public FacebookLoginError loginInvalid() {
		clickElement(buttonLogin);
		return PageFactory.initElements(driver, FacebookLoginError.class);
	}
	
	public void logoutUsingActions() {
		WebElement element = driver.findElement(By.cssSelector("#userNavigationLabel"));
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click().build().perform();	
	}
}
