package gun11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_ActionClass_Alert extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/alerts");

        WebElement alert1 = driver.findElement(By.cssSelector("button#alertButton"));
        alert1.click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        WebElement alert2 = driver.findElement(By.cssSelector("button#timerAlertButton"));
        alert2.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        WebElement alert3 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        alert3.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        String text ="das ist mein Name";
        WebElement promButton = driver.findElement(By.cssSelector("button#promtButton"));
        promButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys(text);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        String expected = "das ist mein Name";
       String isimOnay = driver.findElement(By.cssSelector("span#promptResult")).getText();

       Assert.assertTrue(isimOnay.contains(expected));
        driver.quit();

    }
}
