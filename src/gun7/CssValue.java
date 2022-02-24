package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class CssValue extends BaseStaticDriver {

    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        System.out.println(login.getCssValue("border"));
        System.out.println(login.getCssValue("background-color"));
        System.out.println(login.getCssValue("color")) ;

        login.click();

        WebElement urun = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
        System.out.println(login.getCssValue("padding"));
    }
}
