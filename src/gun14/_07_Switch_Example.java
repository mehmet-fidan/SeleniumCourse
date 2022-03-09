package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.Set;

public class _07_Switch_Example extends BaseStaticDriver {
    /*
    https://www.amazon.com.tr sitesine gidiniz.
    Cerezleri kabul ediniz.
    arama textbox a kitap yaziniz.
    arama butonundan arama yapiniz.
    kitap listesinden 40. kitaba kadar scroll yapip click yapalim.
    twitter iconuna kadar scroll yaipi click yapalim.
    name kısmına  bir text gonderelim.

    /*
    https://www.amazon.com.tr/  siteye gidiniz
    Cerezleri kabul et                                      // input[name='accept']
    arama textbox a "Kitap" yazip ara butonuna click yapalim  // input#twotabsearchtextbox   // input[type='submit']
    Ürün listesinde 40. kitaba e kadar scrool yapalim       (//img[@class='s-image'])[40]
     sonra kitabi click yapalim

     Twitter iconun kadar scroll yapip click yapalim     //  (//a[@target='_blank'])[2]
     name kismina bir text gönderelim        input[type='text']


     */


    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com.tr");

        String anasayaId = driver.getWindowHandle();
        System.out.println("Anasayfa Id= "+anasayaId);

        WebElement cerez = driver.findElement(By.cssSelector("input#sp-cc-accept"));
        cerez.click();

        WebElement textYaz = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        textYaz.sendKeys("kitap");

        WebElement search = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
        search.click();

        WebElement kitap = driver.findElement(By.xpath("(//img[@class='s-image'])[40]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(false);",kitap);
        kitap.click();

        WebElement twitter = driver.findElement(By.xpath("(//a[@target='_blank'])[4]"));

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
      js.executeScript("arguments[0].scrollIntoView(true);",twitter);
        twitter.click();


        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowId : windowHandles) {

            if (windowId.equals(anasayaId)) continue;

            driver.switchTo().window(windowId);
            WebElement nameText = driver.findElement(By.cssSelector("input[name='session[username_or_email]']"));
            nameText.sendKeys("user name");
            Thread.sleep(1000);
            driver.close();

        }

        driver.switchTo().window(anasayaId);
        System.out.println("anasayfa title ="+driver.getTitle());
        driver.quit();


    }
}
