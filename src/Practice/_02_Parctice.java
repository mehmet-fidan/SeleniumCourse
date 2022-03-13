package Practice;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class _02_Parctice extends BaseStaticDriver {

    /*
    Bu siteden bu islemleri 5 kez yaptirip ,rastegele sayilarla toplama,
    cikarma ve select teki diger operatör islemleri yaptirip
    sonucun dogru olup olmadigini kontrol edecegiz
     */
    public static WebDriverWait wait;

    public static void main(String[] args) {

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");


        WebElement first = driver.findElement(By.cssSelector("#number1Field"));

        WebElement second = driver.findElement(By.cssSelector("#number2Field"));

        WebElement add = driver.findElement(By.cssSelector("#selectOperationDropdown"));
        Select option = new Select(add);

        WebElement calculation = driver.findElement(By.cssSelector("#calculateButton"));

        WebElement answer = driver.findElement(By.xpath("(//input[@type='text']) [3]"));

        WebElement clear = driver.findElement(By.cssSelector("#clearButton"));
        WebElement sonucTuru = driver.findElement(By.cssSelector("div[class='col-sm-7'] input[type='checkbox']"));


          int i;
        for ( i = 0; i < option.getOptions().size(); i++) {
            sleep(2000);
            clear.click();
            first.clear();
            second.clear();
            int sayi1 = (int) (Math.random() * 100);
            String sayi1String = String.valueOf(sayi1);
            first.sendKeys(sayi1String);

            sleep(2000);
            int sayi2 = (int) (Math.random() * 100);
            String sayi2String = String.valueOf(sayi2);
            second.sendKeys(sayi2String);
            option.getOptions().get(i).click();
            calculation.click();
            if(i<option.getOptions().size()-1) {
                wait.until(ExpectedConditions.elementToBeClickable(sonucTuru)).click();
            }
            takeScreenShot();
            sleep(3000);
            System.out.println(option.getOptions().get(i).getText() + " is " + answer.getText());

        }

      //  Assert.assertEquals(,answer.getText());


        sleep(2000);
        driver.quit();

    }

    public static WebElement findElement(By element) {

        driver = new ChromeDriver();
        // WebElement choice= driver.findElement(element);
        return driver.findElement(element);//choice;

    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void takeScreenShot (){
        String fileName = "ScreenShot_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile =new File("screenShots\\"+fileName+".png");
        try {
            FileUtils.copyFile(screenFile,destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
