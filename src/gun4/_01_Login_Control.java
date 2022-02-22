package gun4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_Login_Control extends BaseStaticDriver {
   /*
    1- https://www.saucedemo.com/  sitesini acin
            2- Ekranda gorunen usernameleri bir string diziye atiniz
     3- Bu username ve passwordlarını hepsinin login olup olamadığını
    login olduktan sonraki sayfada Products kelimesinin kontrol ederek
    doğrulayınız.
    diğer login kontrolleri için navigate.back kullanınız.
            4- Login olamayan userları ve hata bilgisini yazdırınız.

    */

    public static void main(String[] args) throws InterruptedException {

        // . class temsil ederken ; # id yi temsilediyor.
        // "div[class='login_credentials']" ifadesi yerine -->
        // --> ".login_credentials" veya "div.login_credentials" ifadelerini kullaniriz.

        // ya da "div[id='login_credentials']" ifadesi yerine
        // "#login_credentials" veya "div#login_credentials" ifadelerini kullaniriz.

        driver.navigate().to("https://www.saucedemo.com/");

        WebElement users = driver.findElement(By.cssSelector("#login_credentials"));
        //"div.login_credentials" seklinde de yazabilirdik.
        // System.out.println(users.getText());

        String usersText = users.getText();

        String[] userNames = usersText.split("\n");
        System.out.println("usersNames.length: " + userNames.length);

        for (int i = 1; i < userNames.length; i++) {
            Thread.sleep(2000);
            WebElement userName = driver.findElement(By.id("user-name"));
            userName.clear();
            userName.sendKeys(userNames[i]);

            WebElement password = driver.findElement(By.id("password"));
            password.clear();
            password.sendKeys("secret_sauce");

            WebElement login = driver.findElement(By.id("login-button"));
            login.click();
            List<WebElement> products = driver.findElements(By.cssSelector("span[class='title']"));

            //WebElement products = driver.findElement(By.cssSelector("span[class='title']"));
            // if(products.isEnabled())
            // verdigimiz lokasyonda element yoksa hata verir. yapilmak istenen islemi yapamayaiz.
            if (products.size() == 1) {
                System.out.println(userNames[i]+" Bu user name ile login oldundu...");
                driver.navigate().back();
            } else {
                WebElement errorMessage =driver.findElement(By.cssSelector("div[class='error-message-container error']"));

                System.out.println(userNames[i]+"..kullanici login olamadi... "+errorMessage.getText());
            }
        }
      driver.quit();
    }
}
