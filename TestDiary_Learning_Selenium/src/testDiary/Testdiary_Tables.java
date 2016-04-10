package testDiary;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testdiary_Tables {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

		driver.get(contactUrl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Declaring local variables of type "int" to
		// initialize the value of size. We use this
		// because we want to store the size of the table rows and columns. It
		// has nothing to do with the iteration over the table.
		int colSize = 0;
		int rowSize = 0;

		// Declaring a local variable of type "WebElement" to initialize the
		// value of the webElement (table body)
		WebElement tableBody = driver.findElement(By
				.xpath("//table[@id='testtable']/tbody"));

		// Declaring a local variable of type "List<WebElement>" initialize the
		// value of all webElements associated with
		// the tag name "tr" (Table row). Therefore all table rows in the table
		// body will be stored in a list called "tableRow"
		List<WebElement> tableRow = tableBody.findElements(By.tagName("tr"));

		// .size() used to return the number of elements in a list.
		rowSize = tableRow.size();
		System.out.println("The size of my table rows is: " + rowSize);

		// Using the for each loop to iterate over each table row.
		for (WebElement row : tableRow) {

			// Declaring a local variable of type "List<WebElement>" to
			// initialize the value of all webElements associated with
			// the tag name "td" (Table cell). Therefore all table columns in
			// each table row will be stored in a list called "col"
			List<WebElement> col = row.findElements(By.tagName("td"));

			// size() used to return the number of elements in a list.
			colSize = col.size();

			// get() used to get a particular column. Our table has 3 columns
			// starting from
			// 0 - 2. We are saying at every first column check if the text is
			// equal to "James" using by
			// the getText()
			if (col.get(0).getText().equals("James")) {
				System.out.println("test passed");
			}
		}
		System.out.println("The size of my table column is: " + colSize);

		driver.close();

		System.exit(0);

	}

}
