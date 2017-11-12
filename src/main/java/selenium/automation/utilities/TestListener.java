package selenium.automation.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

	private static TestResults results = new TestResults();

	@Override
	public void onTestSuccess(ITestResult testResult) {
		System.out.print(String.format("Test name [%s] passed.\n", testResult.getName()));
		results.incrementPassed();
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		System.out.print(String.format("Test name [%s] failed.\n", testResult.getName()));
		results.incrementFailed();
	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		results.incrementSkipped();
	}

	@Override
	public void onFinish(ITestContext testContext) {
		try {
			System.out.println(results.getTestSummary());
			results.write();
			results.writeCSV();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}