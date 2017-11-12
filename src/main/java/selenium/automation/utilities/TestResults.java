package selenium.automation.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TestResults {
	int passed;
	int failed;
	int skipped;

	public int getPassed() {
		return this.passed;
	}

	public int getFailed() {
		return this.failed;
	}

	public int getSkipped() {
		return this.skipped;
	}

	public int getTotal() {
		return (this.passed + this.failed + this.skipped);
	}

	public void incrementPassed() {
		this.passed++;
	}

	public void incrementFailed() {
		this.failed++;
	}

	public void incrementSkipped() {
		this.skipped++;
	}

	public String getTestSummary() {
		String result = "";
		result += String.format("PASSED... %s/%s \n", getPassed(), getTotal());
		result += String.format("FAILED... %s/%s \n", getFailed(), getTotal());
		result += String.format("SKIPPED.. %s/%s \n", getSkipped(), getTotal());
		result += String.format("TOTAL.... %s \n", getTotal());
		return result;
	}

	public void write() {
		File file = new File("TestResults.txt");
		try (FileWriter fw = new FileWriter(file); BufferedWriter bWriter = new BufferedWriter(fw)) {
			bWriter.write(String.format("PASSED... %s/%s \n", getPassed(), getTotal()));
			bWriter.write(String.format("FAILED... %s/%s \n", getFailed(), getTotal()));
			bWriter.write(String.format("SKIPPED.. %s/%s \n", getSkipped(), getTotal()));
			bWriter.write(String.format("TOTAL.... %s \n", getTotal()));
		} catch (Exception e) {

		}
	}

	public void writeCSV() {
		File file = new File("TestResults.csv");
		try (FileWriter fw = new FileWriter(file); BufferedWriter bWriter = new BufferedWriter(fw)) {
			bWriter.write(String.format("PASSED,FAILED,SKIPPED,TOTAL\n"));
			bWriter.write(String.format("%s,%s,%s,%s\n", getPassed(), getFailed(), getSkipped(), getTotal()));
		} catch (Exception e) {

		}
	}
}
