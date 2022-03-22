package mentoring;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HotelsCom extends ParentClass {

    /* Bu siteye gidin   :     [https://www.hotels.com/](https://www.hotels.com/)

    Manhattan ' ı aratın.

    Check - in tarihini bugünden 2 gün sonraya seçin.

    Check-out tarihini bugünden 5 gün sonraya seçin.

    Search butonuna tıklayın.

    Mesafe botununda 5. caddeyi seçin.

    Aşağı kaydırın ve en az 50 otelin görüntülendiğinden emin olun

    Tüm otellerin 5. cadde ve Times Meydanı'na 5 mil'den az olduğunu doğrulayın .
     */
    public static void main(String[] args) {


        driver.get("https://www.hotels.com/");

        WebElement manhatan = driver.findElement(By.cssSelector("input[placeholder='örneğin İstanbul']"));
        By uygula = By.cssSelector("button[class='_3pFoIe']");
        By ara = By.cssSelector("div._1RDbO5");
        By uzaklik = By.cssSelector("ul button[aria-label='Uzaklık']");
        By cadde5 = By.xpath("(//div//button[text()='5. Cadde'])[2]");


        manhatan.sendKeys("manhatan", (Keys.ENTER));


        WebElement giris = driver.findElement(By.cssSelector("button[class='_1yFrqc _1ZtnNu']"));
        giris.click();


        Actions actions = new Actions(driver);


        Action action;

        for (int i = 0; i < 15; i++) {
            action = actions.moveToElement(giris).sendKeys(Keys.TAB).pause(500).build();
            action.perform();
            if (i == 5) {
                sleep(2000);
                actions.sendKeys(Keys.ENTER).perform();
            }
            if (i == 14) {
                actions.sendKeys(Keys.ENTER).perform();
            }
        }


        clickTo(uygula);
        clickTo(ara);
        waitFor(uzaklik);
        sleep(2000);
        waitFor(cadde5);


        List<WebElement> listOfHotels = driver.findElements(By.cssSelector("section[class='RO5S5p'] ul[class='_3f26d2'] li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        sleep(2000);

        for (WebElement listOfHotel : listOfHotels) {
            System.out.println(listOfHotel.getText());

        }





        /*
        int actualNumberOfHotels = 0;
        sleep(2000);

        for (WebElement list : listOfHotels) {
            System.out.println( list.getText());
        }

        for (int i = 1; i < listOfHotels.size(); i++) {
            js.executeScript("scroll(0,500)");
            js.executeScript("scroll(250,0");
            String numberOfHotels = String.valueOf(listOfHotels.get(i));
            actualNumberOfHotels = Integer.parseInt(numberOfHotels);
            actualNumberOfHotels += i;
            if (actualNumberOfHotels == 50)
                break;
        }
        System.out.println(actualNumberOfHotels);
       */

        driver.quit();

    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickTo(By locator) {
        driver.findElement(locator).click();
    }

    public static void sendkeysTo(By locator, String str) {
        driver.findElement(locator).sendKeys(str);
    }

    public static void waitFor(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
}

