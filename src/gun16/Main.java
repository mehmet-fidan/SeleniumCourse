package gun16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Main extends BaseClass {

    public static void main(String[] args) {

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        // todo Selenium webbrowser kullanmak icin bir aractir
        WebElement username = driver.findElement(By.cssSelector("input[id='txtUsername']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.cssSelector("input[id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement submitButton = driver.findElement(By.cssSelector("input[id='btnLogin']"));
        submitButton.click();


        // sleep(5000);
        // driver.quit();
    }
}
