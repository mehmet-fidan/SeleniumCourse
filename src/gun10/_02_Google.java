package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_Google extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.google.com/");
       // tusu basili tutmak istedigimizde keyDown ve keyUp ozelligini kullaniyoruz.
       // tusa bir kez basip kadirdigimizde senKeys() kullaniyoruz.
        WebElement google = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        google.click();
        google.sendKeys("Selenium");

        Actions builder = new Actions(driver);

        Thread.sleep(2000);
       Action enter = builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build();
        enter.perform();
        Thread.sleep(2000);
       enter =builder.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build();
       enter.perform();
    }
}
