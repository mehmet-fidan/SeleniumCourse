package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _04_ActionClass_AlertCancel extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmButton.click();
        Thread.sleep(1000);

        driver.switchTo().alert().dismiss();
    }
}
