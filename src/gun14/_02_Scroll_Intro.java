package gun14;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _02_Scroll_Intro extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-2000)");

        Thread.sleep(1000);
        js.executeScript("scroll(0,3000");




    }
}
