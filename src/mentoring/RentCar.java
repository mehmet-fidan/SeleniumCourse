package mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RentCar extends ParentClass {
    /*Bu siteye gidin. (https://www.enterprise.com/en/home.html)

   Miami International Airport'a girin.

   5 gün sonrası için ayarlayın.

  Dönüş için 10 gün sonrayı ayarlayın.

    VEHICLE CLASS 'a tıklayınız.

    Menü'nün içindeki Full size Car'a tıklayınız.

    Apply Filter'a tıklayınız.

    Continue'ya tıklayınız.

    Number of Passengers'ın altından +7'ye tıklayınız.

    Bütün arabaların, minimum 7 kişilik olduğunu doğrulayın.*/

    public static void main(String[] args) {
        driver.get("https://www.enterprise.com/en/home.html");


        WebElement textMiami = driver.findElement(By.cssSelector("#pickupLocationTextBox"));
        textMiami.sendKeys("miami");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Remember my choice"))).click();

        WebElement stayHere = driver.findElement(By.cssSelector("//button[text()='No, Stay Here']"));
        stayHere.click();
        WebElement selectMiamiInternational = driver.findElement(By.id("location-1018659"));
        selectMiamiInternational.click();


        driver.quit();
    }


}
