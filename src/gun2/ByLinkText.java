package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByLinkText {
    public static void main(String[] args) {

        // Sauce Labs Bolt T-Shirt

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement urun1 = driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt"));
        // linkText yalnizca a tag nameli lokasyonda kullanilir.
        System.out.println("urun 1 getText()= " + urun1.getText());
        urun1.click();

        // alt satırdaki gibi de yazilabilir.
        // driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();

        WebElement urun1_partial = driver.findElement(By.partialLinkText("Bolt T-Shirt"));
        System.out.println("urun1_partial getText()= "+urun1_partial.getText());
        urun1_partial.click();
        driver.quit();
    }
}
