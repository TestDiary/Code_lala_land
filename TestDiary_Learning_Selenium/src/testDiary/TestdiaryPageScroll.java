package testDiary;

import org.openqa.selenium.By;

// we have imported the Javascript Executor
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestdiaryPageScroll {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);


        //wait until Selenium can find the link with locator Linktext "Open page in a new window" on the test page.
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in the same window")));


        //Point Selenium to the Element you want to scroll to and get it's Location
        //Store location with Y coordinates in the variable hyperlinkYCoordinate of type integer
        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in the same window")).getLocation().getY();


        //Store location with X coordinates in the variable hyperlinkYCoordinate of type integer
        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in the same window")).getLocation().getX();


        // Use Java Script Executor to scroll down the WebPage to the position where the element is
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;


        // parse the X and Y coordinates from the above into the execute Script method with the following String
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");


        // click on the link
        driver.findElement(By.linkText("Open page in the same window")).click();


        driver.close();
    }

}
