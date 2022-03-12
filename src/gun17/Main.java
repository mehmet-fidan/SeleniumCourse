package gun17;

import org.openqa.selenium.WebDriver;

public class Main {

    public static WebDriver driver;

    public static void main(String[] args) {

       test1();
       test2();

       // 1. Eger getDriver methodunda driver bos ise yeni browser tanimla sarti kosmazsak.
        // program ayni anda birden fazla browser acar.
        // 2. eger getDriver methodunda driver bos ise (driver==null) sartini kosarsak o zaman sedece bir method calisir diger method sarta uymadigi icin calismaz

    }

    public static void test1() {
        driver = Driver.getDriver();
        driver.get("https://www.google.com");
    }

    public static void test2 () {
        driver = Driver.getDriver(Browsers.CHROME);
        driver.get("https://www.yahoo.com");
    }
}
