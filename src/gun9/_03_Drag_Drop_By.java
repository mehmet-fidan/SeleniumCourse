package gun9;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03_Drag_Drop_By extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("scroll(0, 200);"); // basarili
        WebElement sliderBar1 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]"));
        WebElement sliderBar2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]"));

        Actions builder = new Actions(driver);

        Action slide_geri = builder.dragAndDropBy(sliderBar1,-40,0).build();
        Action slide_ileri = builder.dragAndDropBy(sliderBar2,50,0).build();

        slide_geri.perform();
        Thread.sleep(2000);
        slide_ileri.perform();

    }
}
