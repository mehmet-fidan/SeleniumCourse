package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.Set;

public class _04_Odev extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        /*
    https://techno.study/  sitesine gidiniz
    Get free consultation  butonuna click yapiniz
    acilan windowdaki email textbox  yazi gonderiniz

     */

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://techno.study/");

        String ansayfaId = driver.getWindowHandle();

        WebElement freeConsultation = driver.findElement(By.xpath("//td[text()='Free consultation']"));
        freeConsultation.click();
        System.out.println(driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowId : windowHandles) {

            if (windowId.equals(ansayfaId)) continue;

            driver.switchTo().window(windowId);
            System.out.println(driver.getTitle());
            WebElement e_mail = driver.findElement(By.xpath("(//input[@autocomplete='email']) [4] "));
            Thread.sleep(2000);
            e_mail.sendKeys("auot@email.com");
            Thread.sleep(1000);

            driver.close();
        }

        driver.switchTo().window(ansayfaId);
        System.out.println("Anasayfa ID =" + ansayfaId);
        System.out.println("Anasayfa Id title= " + driver.getTitle());

        driver.quit();

    }
}
