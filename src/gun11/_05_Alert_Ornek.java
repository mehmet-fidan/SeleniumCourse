package gun11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _05_Alert_Ornek extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.demo.guru99.com/test/delete_customer.php");

        WebElement customerId = driver.findElement(By.xpath("//input[@name='cusid']"));
        customerId.sendKeys("12345");
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        submit.click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        String alertMessage_2 = driver.switchTo().alert().getText();

        String expected = "Customer Successfully Delete!";
        System.out.println("Alert Message 2 :" + alertMessage_2);
        Assert.assertEquals(expected, alertMessage_2);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.quit();

    }
}
