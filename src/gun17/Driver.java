package gun17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    private static WebDriver driver;
    private static WebDriver wait;


    public static WebDriver getDriver() {

        return getDriver(Browsers.CHROME) ;

    }

    public static WebDriver getDriver(Browsers browser) {

        switch (browser) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\GeckoDriver\\geckodriver.exe");
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
                driver = new FirefoxDriver();
                break;
            case OPERA:
                System.setProperty("webdriver.opera.driver", "C:\\Selenium\\OperaDriver\\OperaSetup.exe");
                driver = new OperaDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
        }
        return driver;
    }
        public static void getQuit () {
            driver.quit();
        }
    }
