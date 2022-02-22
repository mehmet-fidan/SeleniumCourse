package gun3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_Css_Senaryo extends BaseStaticDriver {

    /**
     * https://formsmarts.com/form/yu?mode=h5  bu siteye gidelim
     * Business secin
     * online Advertising secin
     * Every Day secin
     * Average
     * I'm using XYZ for about a week
     * massage kısmına bir yazi gönderelim.
     */

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://formsmarts.com/form/yu?mode=h5");

        WebElement business = driver.findElement(By.cssSelector("input[id^='u_'][id$='_4586_0']")); //"input[id='u_lvy_4586_0']"));
        business.click();

        WebElement selection1 = driver.findElement(By.cssSelector("select[id^='u_'][id$='_4588']"));
        selection1.click();

        WebElement onlineAdvertsing = driver.findElement(By.cssSelector("option[value='Online Advertising']"));
        onlineAdvertsing.click();

        WebElement everyDay = driver.findElement(By.cssSelector("input[id^='u_'][id$='_89585_0']"));
        everyDay.click();

        WebElement average = driver.findElement(By.cssSelector("input[id^='u_'][id$='_4589_1']"));
        average.click();

        WebElement selection2 = driver.findElement(By.cssSelector("select[id^='u_'][id$='_4597']"));
        selection2.click();

        WebElement week = driver.findElement(By.cssSelector("option[value=\"I'm using XYZ for about a week\"]"));
        week.click();  // Eger lokasyon icinde tek tırnak varsa...cift tırnak ile lokasyon buluruz.

        WebElement message = driver.findElement(By.cssSelector("textarea[name=\"u_lvy_89597\"]"));
        message.sendKeys("Bu bir Selenium Testidir.");


        WebElement name = driver.findElement(By.cssSelector("input[name='u_lvy_4598']"));
        name.sendKeys("Mehmet");

        WebElement surname = driver.findElement(By.cssSelector("input[placeholder='Your last name']"));
        surname.sendKeys("Toprak");

        WebElement e_mail = driver.findElement(By.cssSelector("input[type='email']"));
        e_mail.sendKeys("toprakm@gmail.com");

        WebElement date = driver.findElement(By.cssSelector("input[name='u_lvy_14597']"));
        date.sendKeys("22.02.2022");

        WebElement site = driver.findElement(By.cssSelector("input[name='u_lvy_4601']"));
        site.sendKeys("/www.vizyonstore.com/");

        WebElement country = driver.findElement(By.cssSelector("select[id='u_lvy_14598']"));
        country.click();

        WebElement turkey = driver.findElement(By.cssSelector("option[value='TR']"));
        turkey.click();

        WebElement province = driver.findElement(By.cssSelector("option[value='TR-72']"));
        province.click();

        WebElement connect = driver.findElement(By.cssSelector("input[name='u_lvy_4604']"));
        connect.click();

        WebElement comment = driver.findElement(By.cssSelector("textarea[name='u_lvy_4602']"));
        comment.sendKeys("I will be happy to reach here");

        WebElement fortsetzen = driver.findElement(By.cssSelector("input[type='submit']"));
        fortsetzen.click();

         System.out.println("Test fortsetzen");

        Thread.sleep(2000);
         driver.quit();

    }
}
