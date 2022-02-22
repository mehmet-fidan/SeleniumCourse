package gun1;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucedemo {
    public static void main(String[] args) throws InterruptedException {

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

        WebElement urunEkle = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        urunEkle.click();

        WebElement sepetTikla = driver.findElement(By.className("shopping_cart_link"));
        sepetTikla.click();

        WebElement eklenenUrun = driver.findElement(By.className("inventory_item_name"));
        String result = eklenenUrun.getText();
        String expected = "Sauce Labs Backpack";

        Assert.assertEquals("Test tamamlandi...", expected,result);
       // Assert.assertEquals("Sauce Labs Backpack","Sauce Labs Backpack");
       //  Assert.assertTrue(expected.equals(result));
        System.out.println("test basarili");

        //demoblaze.com
    }
}