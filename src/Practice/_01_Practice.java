package Practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class _01_Practice extends BaseStaticDriver {

    public static WebDriverWait wait;

    public static void main(String[] args) {
        driver.get("https://www.etsy.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = driver.findElements(By.cssSelector("ul[data-ui='top-nav-category-list']>li"));
        Actions builder = new Actions(driver);

        for (WebElement topMenu : list) {
            Action move = builder.moveToElement(topMenu).build();
            move.perform();
            sleep(1000);
        }
        sleep(1000);
        By homeLiving = By.cssSelector("#catnav-primary-link-891");
        moveTo(homeLiving);
        sleep(1000);
        By bathBeauty = By.cssSelector("#side-nav-category-link-3288");
        moveTo(bathBeauty);
        By soap = By.cssSelector("#catnav-l3-10980");
        findElement(soap);

        WebElement shop = driver.findElement(By.cssSelector("h3[class='wt-text-title-03 wt-mb-md-1']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", shop);
        sleep(1000);
        findElement(By.cssSelector("#sortby"));
        sleep(1000);
        findElement(By.linkText("Highest Price"));

        //  findElement(By.cssSelector("#catnav-l3-10980"));
        takeScreenShot();
        sleep(2000);


        driver.quit();
    }

    public static void findElement(By locator) {
        // driver.findElement(locator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();

    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void seleniumOption() {
        driver.manage().window().maximize();
    }

    public static void moveTo(By locator) {
        Actions builder = new Actions(driver);
        WebElement elementToMove = driver.findElement(locator);
        Action moveLiving = builder.moveToElement(elementToMove).build();
        moveLiving.perform();

    }

    public static void takeScreenShot() {

        String fileName = "ScreenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss"));

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File screenFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("screenShots\\" + fileName + ".png");
        try {
            FileUtils.copyFile(screenFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
