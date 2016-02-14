import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tables {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

		String Myurl = "http://www.w3schools.com/html/html_tables.asp";

		driver.get(Myurl);

		driver.manage().window().maximize();

		WebElement w3table = driver.findElement(By
				.xpath("//div[@id='main']/table/tbody"));
		List<WebElement> myrows = w3table.findElements(By.tagName("tr"));

		for (int rowsnum = 0; rowsnum < myrows.size(); rowsnum++)

		{

			List<WebElement> columns = myrows.get(rowsnum).findElements(
					By.tagName("td"));

			for (int cnum = 0; cnum < columns.size(); cnum++) {

				String colname = columns.get(cnum).getText();

				if ("John".equals(colname)) {
					System.out.println(myrows.get(rowsnum).getText());
				}

				// System.out.println (columns.get(cnum).getText());

			}

		}

		driver.close();
		System.exit(0);

	}

}
