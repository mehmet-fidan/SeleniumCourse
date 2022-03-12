package gun16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    static {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
                      // 1. Implicit wait
        // aranan herbir elemnet icin elementin presence olmasini bekler.
        // max 10 sn bekleyecek. Her 0,5 snaiyede bir kontrol eder. elementi buldugu ana gecer.
        // driver().manage().timouts().implicitlyWait(10, TimeUnit.SECONDS);

                 // 2. explicit wait
        // elementin beklenen durumuna gore ozel bekleme turudur.
        // bir elementin invisible olmasini beklemek
        // bir elementin clickable olmasini beklemek gibi.....

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickTo(By locator) {
        // 1- driver.findElement(locator).click();
        // 2- WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        // 2- element.click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public static void sendKeysTo(By locator, String str) {
       // driver.findElement(locator).sendKeys(str);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(str);
    }

    public static void takeScreenShot() {
        String fileName = "ScreenShoot_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss"));
       // driverin screenshot yapmasi cast ediliyor.
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        // driver screenshot yapiyor, source file
        File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
        // yazdirilacak dosya
        File destFile = new File("screenShots\\" + fileName + ".png");
        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
