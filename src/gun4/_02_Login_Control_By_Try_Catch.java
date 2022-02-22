package gun4;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02_Login_Control_By_Try_Catch extends BaseStaticDriver {

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

            try {
              //  driver.navigate().refresh();
                WebElement products = driver.findElement(By.cssSelector("span[class='title']"));
                Assert.assertTrue(products.getText().equalsIgnoreCase("products"));
                System.out.println(userNames[i] + " Bu user name ile login oldundu...");
                Thread.sleep(3000);
                driver.navigate().back();
            } catch (Exception ex) {
                // elementi bulamama durumunda Exception hata titpini kullaniyoruz.
                //Assert ile kontrol edeceğimiz zaman AssertionError hata turunu giriyoruz.
                WebElement errorMessage = driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                System.out.println(userNames[i] + "..kullanici login olamadi " + errorMessage.getText());
            }
        }
        driver.quit();
    }
}
