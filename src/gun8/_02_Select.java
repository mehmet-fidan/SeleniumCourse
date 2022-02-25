package gun8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Locale;

public class _02_Select extends BaseStaticDriver {
    public static void main(String[] args) {


  driver.get("https://www.ebay.com/");

        WebElement kategori = driver.findElement(By.cssSelector("select[class='gh-sb ']"));

        Select select = new Select(kategori);
      // select.selectByValue("625");
      //  select.selectByIndex(10); //option"larda index sifirdan basliyor

        List<WebElement> options = select.getOptions(); // option"in get text cekebilmek icin bu ozelligi kullandik.
        options.get(10).click();
        String secim = options.get(10).getText();

        WebElement search = driver.findElement(By.cssSelector("input[type='submit']"));
        search.click();

        WebElement urunIsmi = driver.findElement(By.xpath("(//a[@class='seo-breadcrumb-text'])[2]"));
        System.out.println("urun ismi: "+urunIsmi.getText());

        Assert.assertTrue(secim.contains(urunIsmi.getText()));

        String url = driver.getCurrentUrl();
        System.out.println("url: "+url);

        Assert.assertTrue(url.toLowerCase().contains(secim.toLowerCase()));





    }
}
