package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _06_Switch_To_Window extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();

        driver.get("https://www.selenium.dev/");

        String anaSyafaId = driver.getWindowHandle(); // sayfada yonelme gerceklesmeden once ana sayfanin Id sini aldik.
        System.out.println("Anasayfa Id : " + anaSyafaId);
        //

        WebElement gitHub = driver.findElement(By.xpath("(//a[@target='_blank'])[9]"));
        gitHub.click();
        Thread.sleep(2000);
        Set<String> listId = driver.getWindowHandles();

        for (String windowId : listId) {

             if (windowId.equals(anaSyafaId)) continue;
                driver.switchTo().window(windowId);
                System.out.println("Gecis sonrasi Id= " + windowId);
                System.out.println("driver getTitle= " + driver.getTitle());
                WebElement wiki = driver.findElement(By.cssSelector("span[data-content='Wiki']"));
                wiki.click();
                Thread.sleep(1000);
                driver.close(); // sadece bulundugu window"dan cikar

            }
            Thread.sleep(2000);
            driver.switchTo().window(anaSyafaId); // ilk anasayfaya gecis yaptik.
            Thread.sleep(2000);
            WebElement slack = driver.findElement(By.xpath("(//a[@target='_blank'])[10]"));
            slack.click();

            System.out.println(" son driver getTitle= " + driver.getTitle());

        }
    }

