package gun7;

import gun3._01_Try_Catch;
import gun6.xPath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_Random extends BaseStaticDriver {

    /*
    *https://www.saucedemo.com/  siteye git
    * random bir urun sec.
    * urune tikla
    * bilgilerini kontrol et
    *
     */

    public static void main(String[] args) throws InterruptedException {

        _01_Try_Catch.login("standard_user", "secret_sauce");

        List<WebElement> urunList1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String>  list1 = xPath.elementToString(urunList1);

        List<WebElement> urunPrice1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price1 = xPath.elementToString(urunPrice1);

        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        int random=randomSayi(urunList1.size());
        String randomUrunText = list1.get(random);
        String randomUrunPrice = price1.get(random);

        addToCart.get(random).click();
        urunList1.get(random).click();

        String sepetUrunName =driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        String sepetUrunPrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();

        Assert.assertEquals(randomUrunText,sepetUrunName);
        Assert.assertEquals(randomUrunPrice,sepetUrunPrice);

        Thread.sleep(2000);
        driver.quit();


    }

    public static int randomSayi (int size) {
     return (int) (Math.random()*size);
    }
}
