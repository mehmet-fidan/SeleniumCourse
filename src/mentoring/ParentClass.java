package mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

   static  {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    public void sendKeys(By locator, String str) {
        driver.findElement(locator).sendKeys(str);
    }

}
