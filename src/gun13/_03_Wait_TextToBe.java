package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03_Wait_TextToBe extends BaseStaticDriver {

     /*
    https://www.demoblaze.com/index.html siteye gidiniz
    Login olunuz
    user : Kraft
    pass : 12345
    Ilk once pass yanlis girilip cikan alert onaylanacak
    sonra dogru pass tekrar yollanip
    Login buttonun a basilacak
    Ana sayfada "Welcome Kraft" yazisi görününceye kadar bekleticez

     */

    public static void main(String[] args) throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");

        WebElement login = driver.findElement(By.id("login2"));
        login.click();

        String user = "Kraft";
        WebElement username = driver.findElement(By.id("loginusername"));
        username.sendKeys(user);

        WebElement pass = driver.findElement(By.id("loginpassword"));
        pass.sendKeys("34565");

        WebElement loginTekrar = driver.findElement(By.cssSelector("button[onclick='logIn()']"));
        loginTekrar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();


        pass.clear();
        pass.sendKeys("12345");
        loginTekrar.click();

       boolean welcome = wait.until(ExpectedConditions.textToBe(By.cssSelector("a[id='nameofuser']"),"Welcome "+user));

       String result = driver.findElement(By.cssSelector("a[id='nameofuser']")).getText();
       Thread.sleep(1000);

        System.out.println(" ="+result.equals("Welcome "+user));


        System.out.println("Welcome yazisi "+welcome);

        driver.quit();


    }
}
