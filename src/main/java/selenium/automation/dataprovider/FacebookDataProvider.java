package selenium.automation.dataprovider;

import org.testng.annotations.DataProvider;

import selenium.facebook.pages.FacebookLoginPage;

public class FacebookDataProvider {

	public static String valid = "valid";
	public static String invalid = "invalid";

	@DataProvider(name = "pages")
	public static Object[][] pages() {
		return new Object[][] { { "https://www.facebook.com/", "Facebook - เข้าสู่ระบบหรือสมัครใช้งาน" },
				{ "https://www.google.co.th/", "Google" }, { "https://www.yahoo.com/", "Yahoo" } };
	}

	@DataProvider(name = "login")
	public static Object[][] login() {
		return new Object[][] { { FacebookLoginPage.email, FacebookLoginPage.password, valid },
				{ FacebookLoginPage.emailIncorrect, FacebookLoginPage.passwordIncorrect, invalid }, };
	}

	@DataProvider(name = "signup")
	public static Object[][] signup() {
		return new Object[][] {
				{ "Schoderbek", "Adrianna", "adrianna.schoderbek@general-hospital.com", "14", "2", "2003" },
				{ "Bronw", "Adrianne", "adrianne.bronw@geocities.com", "15", "10", "1991" },
				{ "Shaklee", "Adrien", "adrien.shaklee@geologist.com", "16", "5", "2004" },
				{ "Shoptaw", "Adriene", "adriene.shoptaw@geopia.com", "2", "8", "2002" },
				{ "Tisor", "Adrienne", "adrienne.tisor@gh2000.com", "8", "11", "1998" },
				{ "Blewitt", "Afton", "afton.blewitt@ghanamail.com", "10", "4", "1991" },
				{ "Mabey", "Agatha", "agatha.mabey@ghostmail.com", "25", "12", "1993" },
				{ "Vanscyoc", "Agnes", "agnes.vanscyoc@giantsfan.com", "14", "2", "2005" },
				{ "Grenz", "Agnus", "agnus.grenz@giga4u.de", "23", "4", "1997" },
				{ "Obryant", "Agripina", "agripina.obryant@gigileung.org", "31", "5", "1993" }

		};
	}
}