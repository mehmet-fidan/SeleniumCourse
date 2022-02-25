package gun8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class Action_class extends BaseStaticDriver {

      /*
     --> Action Class ile
         Maus ile sagClick, solClik, doubleClick,


       */

       public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/buttons");

        WebElement ciftTiklama = driver.findElement(By.id("doubleClickBtn"));
        Actions builder = new Actions(driver); // bu islemler driver(tarayici) uzerinden yapildigi icin driver yazdik.
        Thread.sleep(2000);
        Action ciftClick = builder.moveToElement(ciftTiklama).doubleClick().build();
        // yapilcak aksiyon tanimlandi.
        ciftClick.perform(); // asil aksiyon bu kod ile gerceklesiyor.

        WebElement sagTiklama = driver.findElement(By.id("rightClickBtn"));

        Action sagClick = builder.moveToElement(sagTiklama).contextClick().build();
        sagClick.perform();

        WebElement tiklama = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Action click = builder.moveToElement(tiklama).click().build();
        click.perform();


    }
}
