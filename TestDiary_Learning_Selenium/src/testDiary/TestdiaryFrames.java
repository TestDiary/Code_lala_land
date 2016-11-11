package testDiary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestdiaryFrames {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);


        //wait until Selenium can find the frame with locator name "testframe" on the test page.
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));


        // Declaring a local variable of type "WebElement" to initialize the
        // value of the webElement (testframe)
        WebElement testframe = driver.findElement(By.name("testframe"));


        //using the switchTo method you can parse "testframe" webElement as a parameter
        // into the frame method
         driver.switchTo().frame(testframe);


        //get the text displayed in the frame, as selenium is now using the Iframe it was pointed too
        String expectedFrameText =driver.findElement(By.id("testpagelink")).getText();
        String actualFrameText = "My frame text";


        // verify the texts
        if(actualFrameText.equals(expectedFrameText)){
            System.out.println("Found my frame text");
        }
        else {
            System.out.println("Did not find my frame text");
        }

        // This will return driver back to the original Parent Frame
        // Which is the selenium-test-page
        driver.switchTo().parentFrame();

        driver.close();
    }
}
