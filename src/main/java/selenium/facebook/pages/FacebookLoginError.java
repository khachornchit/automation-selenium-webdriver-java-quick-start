package selenium.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import selenium.automation.utilities.BasePage;

public class FacebookLoginError extends BasePage {
	private static String validationEmailText = "����ŷ��س��͹���ç�Ѻ�ѭ�ռ������ ��Ѥ���ҹ�ѭ�ռ����";

	@FindBy(css = "._4rbf._53ij")
	WebElement validationEmail;

	public FacebookLoginError(WebDriver driver) {
		super(driver);
	}

	public void testValidationEmail() {
		Assert.assertTrue(validationEmail.isDisplayed());
		Assert.assertEquals(validationEmail.getText(), validationEmailText);
	}
}