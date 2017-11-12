package selenium.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	private static Properties prop;
	private static String fileConfigProperties = "config.properties";

	public static void loadConfigProperties() throws IOException {
		try {
			prop = new Properties();
			prop.load(getFile(fileConfigProperties));
		} catch (Exception e) {
			System.out.println("Find not found config.properties !");
		}
	}

	private static InputStream getFile(String fileName) throws FileNotFoundException {
		return new FileInputStream("src\\main\\resources\\" + fileName);
	}

	public static String getProperty(String propName) {
		return prop.getProperty(propName);
	}
}
