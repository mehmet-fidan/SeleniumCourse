package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02_CssValueOrnegi extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://form.jotform.com/220466667555061");
        WebElement name= driver.findElement(By.id("first_3"));

        System.out.println("Click ten once: "+name.getCssValue("border-color"));
        name.click();

        Thread.sleep(3000);
        WebElement surname = driver.findElement(By.id("last_3"));
        surname.click();

        WebElement e_mail = driver.findElement(By.id("input_4"));

        e_mail.click();
        System.out.println("Click ten sonra: "+name.getCssValue("border-color"));
    }
}
