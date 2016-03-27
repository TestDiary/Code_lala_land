package TestDiary;
//Import Selenium webdriver and firefox driver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Class Testdiary_VerifyTitle
public class Testdiary_VerifyTitle {
	
	// In every class you need a main method
	public static void main(String[] args) {

		//Open a new Firefox Browser
		WebDriver driver = new FirefoxDriver();

		// Maximise the browser window
		driver.manage().window().maximize();

		// Save the url of the page into a string object	
		String appUrl = "http://www.testdiary.com/";

		// Open the application url
		driver.get(appUrl);

		// Declare and initialise the variable to store the expected title of
		// the web page.
		String expectedTitle = "Test Diary - A software testers guide";

		// Fetch the title of the web page and save it into a string variable
		String actualTitle = driver.getTitle();

		// Use an if condition to check if both string objects are equal
		if (expectedTitle.equals(actualTitle)) {

			System.out
					.println("verification successful - The correct Tile is Displayed on the Webpage");
		} else {
			System.out.println("verification unsuccessful");
		}

		// Close the browser
		driver.close();
		
		// End the program
		System.exit(0);
	}
}
