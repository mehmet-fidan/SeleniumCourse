package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseStaticDriver {

    public static WebDriver driver;

    static {
      //  System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    //    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //ilk driver yuklenirken beklme
    //    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // her element icin
    }

}
