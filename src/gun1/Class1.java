package gun1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com.tr/?hl=tr");
        // driver.get ile islem yapmak istedigimiz siteye gitmek icin
        // o sitenin url"sini giriyoruz.
      //  Thread.sleep(1000);

     //   driver.quit(); // açılan driver açık kalıp bilgisayari yormasın diye driver.quit methodunu ekliyoruz.
        //quit()=

        WebElement onay = driver.findElement(By.id("input"));
        onay.sendKeys("telefon");


    }
}
