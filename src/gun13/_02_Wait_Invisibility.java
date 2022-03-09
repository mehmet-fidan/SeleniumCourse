package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _02_Wait_Invisibility extends BaseStaticDriver {

    /*
     https://the-internet.herokuapp.com/dynamic_controls  siteye gidiniz
     Remove buttonuna basiniz
     wait loading kaybolana kadar bekletin
     Sonrada "It's back! " bu yazini görünürlügünü onaylayin

      */
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement remove = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        remove.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean loading = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='loading']")));
          // todo invisibility ozelligi boolean olarak  degiskene alinabiliyor.
        System.out.println("Loading= "+loading);

        WebElement meassage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[id='message']")));
        System.out.println("Message gorundu mu= "+meassage.isDisplayed());
        System.out.println("Message Text= "+meassage.getText());
         // todo visibility ozelligi WebElement olarak degiskene alinabiliyor.

        Thread.sleep(2000);
        driver.quit();


    }
}
