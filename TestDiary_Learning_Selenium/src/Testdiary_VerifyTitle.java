//import jars for selenium webdriver and firefox driver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// class Testdiary_VerifyTitle
public class Testdiary_VerifyTitle {
	
	// main method
	public static void main(String[] args) {

		// Instantiate a new Firefox object to open a new Firefox Browser
		WebDriver driver = new FirefoxDriver();

		// Maximise the browser window
		driver.manage().window().maximize();

		// save the url of the page into a string	
		String appUrl = "http://www.testdiary.com/";

		// Open the application url
		driver.get(appUrl);

		// declare and initialise the variable to store the expected title of
		// the web page.
		String expectedTitle = "Test Diary - A software testers guide";

		// fetch the title of the web page and save it into a string variable
		String actualTitle = driver.getTitle();

		// use an if condition to check if both string objects are equal
		if (expectedTitle.equals(actualTitle)) {

			System.out
					.println("verification successful - The correct Tile is Displayed on the Webpage");
		} else {
			System.out.println("verification unsuccessful");
		}

		// close the browser
		driver.close();
		
		// end the program
		System.exit(0);
	}
}
