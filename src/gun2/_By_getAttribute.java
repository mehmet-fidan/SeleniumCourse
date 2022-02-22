package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _By_getAttribute {
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
        String a_Type = login.getAttribute("type");
        System.out.println("a_Type="+a_Type);
        System.out.println("a_Class= "+ a_Class);
        //LinkText ve PartialLinkText ile sonuc alamıyoruz...
        // yani getAttribute yapacaksak elementi bu iki veri dısındaki veriler ile bulmuş olamalıyız.

        login.click();


        // id = "us_o1678_2d".....ifadesinde bazı degiskenler sürekli değişkenlik gösterebilir.
        // bunu engellemek için daha çok xPath veya CssSelector kullanmak daha mantıklı.

        // atribute (ozellik) = class, name id gibi ifadeler

        WebElement urun_1 = driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt"));



    }
}