import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testdiary_ContactPage {

	public static void main(String[] args) throws InterruptedException {

		// Open a new firefox browser
		WebDriver driver = new FirefoxDriver();

		// Initialise the variable to store the URL
		String contactUrl = "http://www.testdiary.com/contact/";

		// Navigate to the URL
		driver.get(contactUrl);

		// Allow the current thread (the process) to sleep for some seconds.
		// Gives The page time to load.
		Thread.sleep(4000);

		// locate the Name text box on the webpage. Using the locator "By.name"
		// Store this text box location to the variable "name"
		WebElement name = driver.findElement(By.name("your-name"));

		// clear the text box
		name.clear();

		// Insert your name into the text box using the sendKeys method.
		// I am using my name in this scenario
		// You can input your own name
		name.sendKeys("Femi");

		// locate the email text box. Using the locator By.name
		// store this text box location to the variable "email"
		WebElement email = driver.findElement(By.name("your-email"));

		// clear the text box
		email.clear();

		// Insert your email into the text box using the sendKeys method.
		// I am using my email in this scenario
				// You can input your own email
		email.sendKeys("xxxx@testdiary.com");

		// Insert your subject into the text box
		WebElement subject = driver.findElement(By.name("your-subject"));
		subject.clear();
		subject.sendKeys("New tester");

		// Insert your message into the text box
		WebElement your_message = driver.findElement(By.name("your-message"));
		your_message.clear();
		your_message.sendKeys("I want to be the best tester.");

		// The code in the above should fill up the contact form on Test diary.

		// locate the send button. Using the locator By.xpath
		WebElement send = driver.findElement(By.xpath("//input[@value='Send']"));

		// Use the .click method to click this button
		send.click();

		// Allow the current thread (the process) to sleep for some seconds.
		// Gives The page time to load.
		Thread.sleep(4000);

		/*
		 * Message after sending inquiry. locate the success message banner,
		 * using the locator By.xpath Insert the .getText() method after the 
		 * locator to let Selenium get the text
		 * from the Webelement you have located
		 */
		String actual_message = driver.findElement(By.xpath("//div[@id='wpcf7-f548-p96-o1']/form/div[2]")).getText();

		// Declare and initialise the variable to store the expected success message of the web page.
		String expected_message = "Your message was sent successfully. Thanks.";

		// Use an if condition to check if both string objects are equal
		if (expected_message.equals(actual_message)) {

			System.out.println("verification successful - " + actual_message);
		} else {
			System.out.println("verification unsuccessful");
		}

		// Close the browser
		driver.close();

		// End the program
		System.exit(0);
	}

}
