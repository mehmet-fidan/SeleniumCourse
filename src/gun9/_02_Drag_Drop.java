package gun9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_Drag_Drop extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norvec = driver.findElement(By.id("box101"));
        System.out.println("Oslo before action :" + oslo.getCssValue("background-color"));

        Actions builder = new Actions(driver);
        Action action = builder.dragAndDrop(oslo, norvec).build();
        action.perform();
        System.out.println("Oslo before action :" + oslo.getCssValue("background-color"));
        String expectedColor = "rgba(0, 255, 0, 1)";
        Assert.assertEquals("not same.....", expectedColor, oslo.getCssValue("background-color"));

        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement spain = driver.findElement(By.id("box107"));

        //  Action madridSpain = builder.clickAndHold(madrid).moveToElement(spain).build();
        //   madridSpain.perform();

        action = builder.dragAndDrop(madrid, spain).build();
        action.perform();

        Assert.assertEquals("not same.....", expectedColor, madrid.getCssValue("background-color"));

        Thread.sleep(2000);
        driver.quit();
    }
}
