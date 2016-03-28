package testDiary;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestdiaryDropDowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

		driver.get(contactUrl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		// Select from the drop down by visible text
		new Select(driver.findElement(By.id("Shirts")))
				.selectByVisibleText("Red Shirt");

		// we are using this thread.sleep, so you can verify that Selenium picks
		// Red Shirt from the
		// drop down
		Thread.sleep(1000);

		// Select from the drop down by value
		new Select(driver.findElement(By.id("Skirts")))
				.selectByValue("YellowSkirt");

		// we are using this thread.sleep, so you can verify that Selenium picks
		// Yellow Skirt from the
		// drop down
		Thread.sleep(1000);

		
		
		WebElement name = driver.findElement(By.name("your-name"));

		name.clear();

		name.sendKeys("Femi");

		WebElement email = driver.findElement(By.name("your-email"));

		email.clear();

		email.sendKeys("xxxx@testdiary.com");

		WebElement subject = driver.findElement(By.name("your-subject"));
		subject.clear();
		subject.sendKeys("New tester");

		WebElement your_message = driver.findElement(By.name("your-message"));
		your_message.clear();
		your_message.sendKeys("I want to be the best tester.");

		WebElement send = driver
				.findElement(By.xpath("//input[@value='Send']"));

		send.click();
		
		String expected_message = "Your message was sent successfully. Thanks.";

		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.textToBePresentInElementLocated(
						By.xpath("//div[@id='wpcf7-f551-p683-o1']/form/div[2]"),
						expected_message));

		String actual_message = driver.findElement(
				By.xpath("//div[@id='wpcf7-f551-p683-o1']/form/div[2]"))
				.getText();

		if (expected_message.equals(actual_message)) {

			System.out.println("verification successful - " + actual_message);
		} else {
			System.out.println("verification unsuccessful");
		}

		driver.close();

		System.exit(0);
	}
}
