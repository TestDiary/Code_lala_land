import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OurJunitTEST {

	@BeforeClass
	public static void login() {

		System.out.println("\n Mahender login (Before)");
	}

	@AfterClass
	public static void logout() {
		System.out.println("Mahender logout (After)");
	}

	@Test
	public void verifyTitle() {
		System.out.println("check  (Test1)");

	}

	@Test
	public void checkEmail() {
		System.out.println("checking email (Test2)");

	}

	@Test
	public void checkDrafts() {
		System.out.println("checking Draft (Test3)");
	}

}
