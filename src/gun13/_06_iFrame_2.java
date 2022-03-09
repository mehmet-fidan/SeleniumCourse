package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _06_iFrame_2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {


        driver.get("https://chercher.tech/practice/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(3000);
        driver.switchTo().frame(0);  // "frame1"
        // sitede birden fazla iframe var. Frame gecisi yapilmadiginda o alandaki elemente ulasamiyoruz
        Thread.sleep(3000);
        driver.switchTo().frame(0);  //"frame3"
        // frame1 in altindaki ilk frame oldugu icin yine sifir oldu
        WebElement checkBox = driver.findElement(By.cssSelector("input#a"));
        checkBox.click();
        System.out.println("checkBox = " + checkBox.isSelected());
        Thread.sleep(3000);
        driver.switchTo().parentFrame();  // todo frame den cikmak icin bu kodu kullandik  inner framden ciktik
        Thread.sleep(3000);
        driver.switchTo().parentFrame();  // todo frame den cikmak icin bu kodu kullandik   frame1 den ciktik
        Thread.sleep(3000);
       // WebElement selenium = driver.findElement(By.xpath("(//a[@class='nav-link head'])[2]"));
       // selenium.click();

        //driver.quit();
    }

    }
