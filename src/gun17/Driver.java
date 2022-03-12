package gun17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    /* driver Uretecek
    projede driver kullanirken, driver cu classdan istenecek
    chrome, firefox, ie edge, opera,......
     */


    private static WebDriver driver;
    private static WebDriver wait;


    public static WebDriver getDriver() {

        return getDriver(Browsers.CHROME);

    }

    public static WebDriver getDriver(Browsers browser) {

        if (driver == null) {
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\GeckoDriver\\geckodriver.exe");
                    System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    System.setProperty("webdriver.edge.driver", "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Microsoft Edge.lnk");
                    driver = new EdgeDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
                    driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public static void getQuit() {
        driver.quit();
    }
}
