package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _05_OpenWindow extends BaseStaticDriver {

    public static void main(String[] args) {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();

        driver.get("https://www.selenium.dev/");

        String anaSyafaId = driver.getWindowHandle(); // sayfada yonelme gerceklesmeden once ana sayfanin Id sini aldik.
      
      
        List<WebElement> targetLinks = driver.findElements(By.cssSelector("a[target='_blank']"));
         // Bu list click yapildiginda farkli sekmede acilan linklerin listesi
        for (WebElement links : targetLinks) { // Listedeki butun elementleri click yaptik.
            links.click();
        }

        Set<String> windowHandles = driver.getWindowHandles();
        //farkli sayfada acilan linklerin Id lerini Set ile kayit altina aldik.

        System.out.println("linklerin Id leri:");
        for (String id : windowHandles) {
            System.out.println(id);
        }

        // Bu Id ler her seferinde degistigi icin Id ile yakalayamayiz.

    }
}
