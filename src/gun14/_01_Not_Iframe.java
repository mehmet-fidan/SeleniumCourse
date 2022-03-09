package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _01_Not_Iframe extends BaseStaticDriver {

    public static void main(String[] args) {

        driver.get("https://de.aliexpress.com/?gatewayAdapt=glo2deu");

        WebElement close = driver.findElement(By.className("_24EHh"));
        close.click();

        WebElement close2 = driver.findElement(By.className("close-btn"));
        close2.click();


    }
}
