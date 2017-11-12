package selenium.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import selenium.automation.utilities.BasePage;

public class FacebookSignupPage extends BasePage {
	private final String defaultFirstName = "default first name";
	private final String defaultLastName = "defatul last name";
	private final String defaultPhoneOrEmail = "default@plutosolutions.com";
	private final String defaultPassword = "test!@#$%";

	@FindBy(name = "firstname") WebElement elementFirstName;
	@FindBy(name = "lastname") WebElement elementLastName;
	@FindBy(name = "reg_email__") WebElement elementEmail;
	@FindBy(name = "reg_email_confirmation__") WebElement elementReenterEmail;
	@FindBy(name = "reg_passwd__") WebElement elementPassword;

	@FindBy(css = "#day") WebElement elementBirthDay;
	@FindBy(css = "#month") WebElement elementBirthMonth;
	@FindBy(css = "#year") WebElement elementBirthYear;

	@FindBy(css = "span input[name='sex']") WebElement female;
	@FindBy(css = "span+span input[name='sex']") WebElement male;

	public FacebookSignupPage(WebDriver driver) {
		super(driver);
		this.pageTitle = "Facebook - เข้าสู่ระบบหรือสมัครใช้งาน";
		this.pageUrl = "https://www.facebook.com/";
	}
	
	public void fillSignup() {
		setElementText(elementFirstName, defaultFirstName);
		setElementText(elementLastName, defaultLastName);
		setElementText(elementEmail, defaultPhoneOrEmail);
		setElementText(elementReenterEmail, defaultPhoneOrEmail);
		setElementText(elementPassword, defaultPassword);

		setBirthday("8");
		setMonth("8");
		setYear("2010");
		
		clickElement(male);
	}
	
	public void fillSignup(String firstName, String lastName, String email, String bDay, String bMonth, String bYear) {
		setElementText(elementFirstName, firstName);
		setElementText(elementLastName, lastName);
		setElementText(elementEmail, email);
		setElementText(elementReenterEmail, email);
		setElementText(elementPassword, defaultPassword);

		setBirthday(bDay);
		setMonth(bMonth);
		setYear(bYear);
		
		clickElement(male);
	}
	
	public void setFirstName(String text) {
		setElementText(elementFirstName, text);
	}
	
	public void setLastName(String text) {
		setElementText(elementLastName, text);	
	}
	
	public void setEmail(String text) {
		setElementText(elementEmail, text);
	}
	
	public void setReenterEmail(String text) {
		setElementText(elementReenterEmail, text);
	}
	
	public void setPassword(String text) {
		setElementText(elementPassword, text);
	}

	public void setBirthday(String value) {
		Select select = new Select(elementBirthDay);
		select.selectByValue(value);		
		Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), value);
	}

	public void setMonth(String value) {
		Select select = new Select(elementBirthMonth);
		select.selectByValue(value);		
		Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), select.getOptions().get(Integer.parseInt(value)).getText());
	}

	public void setYear(String value) {
		Select select = new Select(elementBirthYear);
		select.selectByValue(value);		
		Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), value);
	}
}
