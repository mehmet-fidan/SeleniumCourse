package gun9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _01_Drag_Drop extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        Thread.sleep(2000);

        //  driver.switchTo().frame("html den alınacak ifadeyi yaz");
        // ekranda devam icin iframe olustu onu asabilmek icin bu kodu yazıyoruz. iframe icin id kullanimi daha efektiv
        //   WebElement iframe = driver.findElement(By.xpath(""));
        //    iframe.click();

        WebElement bank = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));

        WebElement target = driver.findElement(By.cssSelector("#bank"));

        Actions builder = new Actions(driver);

        //  Action tasima = builder.clickAndHold(bank).moveToElement(target).release().build();
        Action tasima = builder.dragAndDrop(bank, target).build();

        tasima.perform();


    }
}
