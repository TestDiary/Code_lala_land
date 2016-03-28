package testDiary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testdiary_ExplicitAndImplicitWait {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

		driver.get(contactUrl);

		// wait 10 seconds until presence of element is located
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.presenceOfElementLocated(By.name("your-name")));

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

		// *Tells WebDriver to wait for 7 seconds
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		String actual_message = driver.findElement(
				By.xpath("//div[@id='wpcf7-f551-p683-o1']/form/div[2]"))
				.getText();

		String expected_message = "Your message was sent successfully. Thanks.";

		if (expected_message.equals(actual_message)) {

			System.out.println("verification successful - " + actual_message);
		} else {
			System.out.println("verification unsuccessful");
		}

		driver.close();

		System.exit(0);
	}
}
