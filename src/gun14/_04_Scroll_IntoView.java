package gun14;

import net.jodah.failsafe.function.CheckedRunnable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _04_Scroll_IntoView extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);

        WebElement element = driver.findElement(By.cssSelector("div[class='text-center font-bold text-3xl']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

       // js.executeScript("arguments[0].scrollIntoView()",element); // pencere secilen elementi en ustte baz alacak sekilde sayfayi konumlandirir.
                                                                     // scrollIntoView(true) ile ayni islevi goruyor.

        // js.executeScript("arguments[0].scrollIntoView(true)", element);
       js.executeScript("arguments[0].scrollIntoView(false)", element); // pencere secilen elementi en altta baz alacak sekilde sayfayi konumlandirir.

    }
}
