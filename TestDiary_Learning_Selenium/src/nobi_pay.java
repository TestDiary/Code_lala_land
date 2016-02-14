import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class nobi_pay {

	 public static void main(String[] args) {
	
	 WebDriver driver = new FirefoxDriver();

     String Myurl = "nobipay.com";

     driver.get(Myurl);
     
     driver.manage().window().maximize();
     
     WebElement username = driver.findElement(By.id("userLogin_UserName"));

     username.clear();

     username.sendKeys("hello");
     
     
     WebElement passward = driver.findElement(By.id("userLogin_Password"));

     passward.clear();

     passward.sendKeys("neverending");
     
     
     System.out.println("My test has passed");
     
     driver.close();
     System.exit(0);
     
}
}