package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;



public class Select_Practice {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://form.jotform.com/220466667555061");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_3']"));
        firstName.sendKeys("Selenium");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_3']"));
        lastName.sendKeys("World");



        WebElement adress_Line1 = driver.findElement(By.xpath("//input[@name='q5_address[addr_line1]']"));
        adress_Line1.sendKeys("Toronto, Canada");

        WebElement adress_City = driver.findElement(By.xpath("//input[@name='q5_address[city]']"));
        adress_City.sendKeys("Toronto");

        WebElement zipcode = driver.findElement(By.xpath("//input[@name='q5_address[postal]']"));
        zipcode.sendKeys("2022");

        JavascriptExecutor je = (JavascriptExecutor) driver;
       // je.executeScript("scroll(0, 200);"); // basarili
       // je.executeScript("arguments[0].scrollIntoView();",zipcode); // basarili
        je.executeScript("arguments[0].scrollIntoView(true);",zipcode); // basarili

       //  je.executeScript("arguments[0].scrollIntoView(false);",zipcode); // basarisiz
       // je.executeScript("window.scrollBy(0,400"); // basarisiz

        Thread.sleep(2000);
        WebElement pleaseSelect = driver.findElement(By.cssSelector("select[class='form-dropdown form-address-country noTranslate'"));

        Select country = new Select(pleaseSelect);
       // country.selectByValue("The Bahamas"); // basarili
        country.selectByIndex(22);
        Thread.sleep(2000);
        WebElement select_It = driver.findElement(By.xpath("//select[@data-component='dropdown']"));

        Select it_Select = new Select(select_It);
        // it_Select.selectByValue("SDET"); //basarili
        it_Select.selectByIndex(3);

        WebElement date = driver.findElement(By.xpath("//input[@id='lite_mode_10']"));
        date.sendKeys("02.22.2022");

        WebElement message = driver.findElement(By.xpath("//textarea[@name='q8_message']"));
        message.sendKeys("Job done");


        je.executeScript("scroll(200, 0);"); // basarili
        WebElement e_mail = driver.findElement(By.xpath("//input[@name='q4_email']"));
        e_mail.sendKeys("world@gmail.com");

        Thread.sleep(2000);
        je.executeScript("scroll(0, 600);"); // basarili

        WebElement submit = driver.findElement(By.cssSelector("button[id='input_2'"));
        submit.click();
        System.out.println("Test done.....");


    }
}
