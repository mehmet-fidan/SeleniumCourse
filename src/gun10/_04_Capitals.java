package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _04_Capitals extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        // locator bulurken * --> contains ifade eder.
        // locator bulurken ^ --> starts with ifade eder.


        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        List<WebElement> capitals = driver.findElements(By.cssSelector( "div[id='dropContent'] div[id*='box']")); // "div[id='dropContent'] div[id^=box]"
        List<WebElement> countries = driver.findElements(By.cssSelector("div[id='countries'] div[id^=box]"));

        Actions builder = new Actions(driver);
        Action tasima;
        String expectedColor= "rgba(0, 255, 0, 1)";

        for (int i = 0; i < capitals.size(); i++) {
            for (int j = 0; j < countries.size(); j++) {
                tasima = builder.dragAndDrop(capitals.get(i), countries.get(j)).build();
                tasima.perform();
                if (capitals.get(i).getCssValue("background-color").equals(expectedColor)) {
                    break;
                }
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}