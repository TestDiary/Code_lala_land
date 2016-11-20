package testDiary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;


public class TestdiaryWindows {

    public static void main(String[] args) {

        // Declare a local variable of type "String"
        String firstPageWindowHandle;

        // Declare a local variable of type "String" and initialize it to store null
        String secondTestWindowHandle = null;

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);


        //wait until Selenium can find the link with locator linktext "Open page in a new window" on the test page.
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));


        // Store the window handle of the  current Sample test page
        // in the variable firstPageWindowHandle
        firstPageWindowHandle = driver.getWindowHandle();


        // Explained in the previous post
        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getY();
        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in a new window")));


        // click on the link, which opens up a new window
        driver.findElement(By.linkText("Open page in a new window")).click();


        //At this point we have two windows opened.
        // Store both window handles in the variable testPageWindowHandle of type Set<String>
        Set<String> testPageWindowHandle = driver.getWindowHandles();


        //iterate through the set testPageWindowHandle
        for (String windowHandle : testPageWindowHandle) {
            //while iterating through the set, check if firstPageWindowHandle which should be
            // the sample test page, is equal to any of the two window handles in testPageWindowHandle set.
            if (!firstPageWindowHandle.equals(windowHandle)) {
                // if  firstPageWindowHandle is not equal to a window handle in the set
                // then make secondTestWindowHandle equal to that window handle
                secondTestWindowHandle = windowHandle;
            }
        }

        //using the switchTo method you can parse "secondTestWindowHandle" webElement as a parameter
        // into the window method
        // This will point selenium to the second test window, where you can test on
        driver.switchTo().window(secondTestWindowHandle);

        //wait until Selenium can find the link with locator name "testpagelink" on the  second test page.
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));


        // This will close the second test page.
        driver.switchTo().window(secondTestWindowHandle).close();


        //using the switchTo method you can parse "firstPageWindowHandle" webElement as a parameter
        // into the window method
        // This will point selenium to the first test window, where you can test on
        driver.switchTo().window(firstPageWindowHandle);

        //wait until Selenium can find the link with locator linktext "Open page in a new window" on the test page.
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));


        driver.close();

    }

}
