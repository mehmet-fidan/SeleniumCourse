package Practice;

import gun16.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class VizyonPract {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.comcec.org/tr/");

     List<WebElement> anaMenu = driver.findElements(By.cssSelector("#avia-menu>li"));

        Actions builder = new Actions(driver);
        Action git;

        for (WebElement menu : anaMenu) {

            git =builder.moveToElement(menu).build();
            git.perform();
            Thread.sleep(1000);

        }
  Thread.sleep(5000);
 driver.quit();

    }
}
