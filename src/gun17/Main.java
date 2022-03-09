package gun17;

import org.openqa.selenium.WebDriver;

public class Main {

    public static WebDriver driver;
    public static void main(String[] args) {

        driver =Driver.getDriver(Browsers.OPERA);
         driver.get("https://www.vizyonstore.com/");


    }
}
