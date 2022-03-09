package gun16;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class Main1 extends BaseClass {

    public static void main(String[] args) throws IOException {

        By usernameText = By.cssSelector("#txtUsername");
        By passwordText = By.cssSelector("#txtPassword");
        By submitButton = By.cssSelector("#btnLogin");
        By welcome = By.cssSelector("#welcome"); // hatali almak icin locatori yanlis girdim.

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        sendKeysTo(usernameText, "Admin");
        sendKeysTo(passwordText, "admin123");
        clickTo(submitButton);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcome));
        } catch (Exception e) {
            takeScreenShot();

        }

       takeScreenShot();
        sleep(5000);
        driver.quit();
    }
}
