package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class _01_WaitGiris extends BaseStaticDriver {

    public static void main(String[] args) {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  // driver ilk acilirken yuklenmesini bekletiyoruz.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  // pageLoadTimeout güncel kullanimi
       // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  // her element icin bekleme suresi.
                                                                            // eleman bulundugu anda bekleme biter
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  // ImpilicitlyWait Güncel Kullanimi
        // Thread.sleep(1000); a) java"ya ait bir bekletme kodudur.
                             // b) Elementi bulsa da verilen sureyi bekler.
        WebElement button = driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();

        // butona click yapildiktan sonra olusan lokasyon

        WebElement wedDriver = driver.findElement(By.xpath("//p[text()='WebDriver']"));
        System.out.println("webDriver = "+wedDriver.getText());
    }
}
