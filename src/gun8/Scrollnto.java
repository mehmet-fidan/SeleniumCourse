package gun8;

import gun3._01_Try_Catch;
import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class Scrollnto extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {




        JavascriptExecutor je = (JavascriptExecutor) driver;
        // je.executeScript("scroll(0, 200);"); // basarili
        // je.executeScript("arguments[0].scrollIntoView();",zipcode); // basarili
       // je.executeScript("arguments[0].scrollIntoView(true);",element); // basarili
        //  je.executeScript("arguments[0].scrollIntoView(false);",zipcode); // basarisiz
        // je.executeScript("window.scrollBy(0,400"); // basarisiz
        Thread.sleep(3000);
    }
}
