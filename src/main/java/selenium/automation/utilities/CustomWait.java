package selenium.automation.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomWait {
	public static ExpectedCondition<Boolean> visibilityOfElement(final WebElement element) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				try {
					return element.isDisplayed();
				} catch (NoSuchElementException e) {
					System.out.println("No Such Element Exception!");
					return false;
				} catch (StaleElementReferenceException e1) {
					return false;
				}
			}
		};
	}
}
