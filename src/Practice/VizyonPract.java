package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VizyonPract {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://evdekal.hacettepe.edu.tr/login/index.php");


        //  WebElement signIn = driver.findElement(By.id("login2"));
        // signIn.click();


        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("21869713");
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("198348");
        WebElement giris = driver.findElement(By.cssSelector("button[id='loginbtn']"));
        giris.click();

        WebElement ders = driver.findElement(By.xpath("(//span[@class='multiline'])[2]"));
        ders.click();

        System.out.println("test basarili");

    }
}
