package selenium.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.automation.utilities.BasePage;

public class FacebookLoginPage extends BasePage  {
	public static final String email = "kokoszka.abbie@gmail.com";
	public static final String password = "koko123456";
	
	public static final String email2 = "clbsqatester@gmail.com";
	public static final String password2 = "clbs123456!@#$%^";
		
	public static final String emailIncorrect = "clbsxx@gmail.com";
	public static final String passwordIncorrect = "clbs1234";

	@FindBy(css = "#email") WebElement fieldEmail;
	@FindBy(css = "#pass") WebElement fieldPassword;
	@FindBy(css = "#loginbutton")WebElement buttonLogin;
		
	public FacebookLoginPage(WebDriver driver) {
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

	public void setTextEmailCorrect() {
		setElementText(fieldEmail, email);
	}

	public void setTextPasswordCorrect() {
		setElementText(fieldPassword, password);
	}
	
	public FacebookMainPage loginCorrect() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
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