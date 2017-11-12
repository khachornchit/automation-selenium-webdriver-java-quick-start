package selenium.facebook.pages.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium.automation.utilities.TestListener;

@Listeners(TestListener.class)
public class fbListenerTest {
	@Test (priority = 1)
	public void test1Success() {
		Assert.assertTrue(true);
	}
	
	@Test 
	public void test2Fail() {
		Assert.assertTrue("I'm asserting false.", false);
	}
	
	@Test (dependsOnMethods = "test2Fail")
	public void test3Skip() {
		Assert.assertTrue(true);
	}
}