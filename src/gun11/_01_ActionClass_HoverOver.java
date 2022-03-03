package gun11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseStaticDriver;

public class _01_ActionClass_HoverOver extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://demo.guru99.com/test/drag_drop.html");
// TODO: 28.02.2022 iframe geçmek için  ...konumu bulup name ve id ile kapatmamiz gerekiyor.
        // todo switchTo().frame(".....")

      //todo  WebElement akzeptieren = driver.findElement(By.xpath("..."));
      // todo  akzeptieren.click();

        WebElement loan = driver.findElement(By.xpath("//a[text()=' LOAN ']"));

        System.out.println("Before Action..."+loan.getCssValue("color"));
        Actions builder = new Actions(driver);

        Action action = builder.moveToElement(loan).build();
        action.perform();

        System.out.println("Action sonrasi color..."+ Color.fromString(loan.getCssValue("color")).asHex());
        //asHex dedigimizde bu formatta aliriz.
        System.out.println("Action sonrasi color..."+ Color.fromString(loan.getCssValue("color")).asRgb());
        // default olarak renk aldığımızda Rgba formatında alriz....

        String expected ="#ee7933";
        String result = Color.fromString(loan.getCssValue("color")).asHex();
        Assert.assertEquals(expected,result);

        driver.quit();



    }
}
