package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _04_Wait_Title extends BaseStaticDriver {
        /*
        https://www.yogaalliance.org/  siteye gidiniz
        Action ile Become a Member uzerine geliniz
        Teacher click yapiniz
        title  "Teachers | Yoga Alliance"  olana kadar beklet

     */

    public static void main(String[] args) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.yogaalliance.org/");

        Actions builder = new Actions(driver);

        WebElement becomeMember = driver.findElement(By.xpath("(//a[@class='sf-with-ul']) [2]"));

        Action moveTo = builder.moveToElement(becomeMember).build();
        moveTo.perform();

        WebElement teachers = driver.findElement(By.xpath("(//a[text()='Teachers']) [2]"));
        teachers.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        String expectedTitle = "Teachers | Yoga Alliance";
        //        boolean title = wait.until(ExpectedConditions.titleContains(expected));
       boolean title= wait.until(ExpectedConditions.titleIs(expectedTitle));

        System.out.println(title);

       String result = driver.getTitle();
        System.out.println("result title= "+title);



    }
}
