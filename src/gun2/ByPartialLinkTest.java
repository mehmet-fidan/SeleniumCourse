package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByPartialLinkTest {
    public static void main(String[] args) {

        // Sauce Labs Bolt T-Shirt

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        String a_Class = login.getAttribute("class");
        System.out.println(a_Class);

        login.click();


        WebElement urun1_partial = driver.findElement(By.partialLinkText("Bolt T-Shirt"));
        System.out.println("urun1_partial getText()= " + urun1_partial.getText());

        urun1_partial.click();

        // id = "us_o1678_2d".....ifadesinde bazı degiskenler sürekli değişkenlik gösterebilir.
        // bunu engellemek için daha çok xPath veya CssSelector kullanmak daha mantıklı.

        // atribute (ozellik) = class, name id gibi ifadeler


    }
}