package gun3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02_Navigate_To extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

     //   _Try_Catch.Login("standard_user","secret_sauce");
        //   Method"un icinde driver.get() ozelligi kullanildigi icin
        // burada bu methodu kullanmadik.

        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        Thread.sleep(3000);
        WebElement urun = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']"));
        urun.click();

        Thread.sleep(3000);

        // https://www.saucedemo.com/inventory.html
        driver.navigate().back();
        String backcurrent = driver.getCurrentUrl();
        try {
            String backExpected = "https://www.saucedemo.com/inventory.html..";
            Assert.assertEquals("Kod Hatali calisti 1:",backExpected,backcurrent);
        } catch (AssertionError error) {
            System.out.println("error.getMassage() ="+error.toString());
        }

        Thread.sleep(3000);

        //https://www.saucedemo.com/inventory-item.html?id=4
        driver.navigate().forward();
        String forwardCurrent = driver.getCurrentUrl();
        String forwardExpected = "https://www.saucedemo.com/inventory-item.html?id=4";
        Assert.assertEquals("Kod Hatali calisti 2:",forwardExpected,forwardCurrent);

        if (forwardCurrent.equals(forwardExpected)){
            System.out.println("Kodunuz hatasiz calisti");
        }

        Thread.sleep(3000);
        driver.quit(); //Senaryo ile acilan tum sayfalari kapatir.
        // driver.close(); // sadece en son acik olan tek sayfayi kapatir.

    }
}
