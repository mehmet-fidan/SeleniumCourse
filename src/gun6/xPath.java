package gun6;

import gun3._01_Try_Catch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class xPath extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        /* https://www.saucedemo.com/  siteye git
         * Urunleri sırasıyla ekle
         * sepete ekle
         * sepetteki urunleri sitedeki ile kıyasla
         * dogru ise check out yap.
         * cikan formu doldur
         * continue yap
         * total fiyati kiyasla
         * finish butonuna tıkla
         * "Thank you for your order" yazisini gordugunu onayla
         * back home de. ve sayfanın url ini kontrol et.

         */

        _01_Try_Catch.login("standard_user", "secret_sauce");
        // icin //tagName[@attribute='value'] seklinde yazilir.

        List<WebElement> urunList1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        // todo tagname a olmayan [Linktext ve partialLinkText olan metinller a tagname ile bulunur] textlerde lokasyon bulmak isteniyorsa xPath kullanmak avantajli.
        //todo Eger site farkli dil seceneleri ile yapilmis ise sadece tek bir dil ile calisir.
        // XPath de text alacaksak @ ifadeini koymamiza gerek kalmiyor.

        List<String> list1 = new ArrayList<>();

        for (WebElement item : urunList1) {
            list1.add(item.getText());
        }
        System.out.println(list1);

        List<WebElement> urunPrice1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price1 = new ArrayList<>();
        for (WebElement price : urunPrice1) {
            price1.add(price.getText());
        }
        System.out.println(price1);

        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (WebElement add : addToCart) {
            //   System.out.println(add.getText());
            add.click();
        }
        WebElement sepetEkle = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepetEkle.click();

        List<WebElement> urunList2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> list2 = elementToString(urunList2);
        stringListControl(list1, list2);
        List<WebElement> urunPrice2 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price2 = elementToString(urunPrice2);
        if (list1.size()== list2.size()) {
            stringListControl(price1, price2);

        } else System.out.println("Listenin uzunlugu esit degil");

        System.out.println("**********************");

        WebElement checkOut = driver.findElement(By.xpath("//button[@data-test='checkout']"));
        checkOut.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys("Februar");

        WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@id,'last')]"));
        lastName.sendKeys("Monat");

        WebElement zipCode = driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']"));
        zipCode.sendKeys("2022");

        WebElement fortsetzen = driver.findElement(By.xpath("//input[@type='submit']"));
        fortsetzen.click();

        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));

       Double sumPrice= 0.0;

       for (String p: price2) {
           sumPrice+=stringToDouble(p);
       }
        System.out.println("sum price: "+sumPrice);

       Double totalDouble = stringToDouble(totalPrice.getText());
        System.out.println("total double: "+totalDouble);

        Assert.assertTrue(sumPrice.equals(totalDouble));

        if (sumPrice.equals(totalDouble)) {
            System.out.println("Fiyat Toplami Dogru");
        }


       WebElement finish = driver.findElement(By.xpath("//button[@id='finish']"));
       finish.click();

       WebElement thanksYaz1= driver.findElement(By.xpath("//h2[@class='complete-header']"));

       String thanksYaz2 = "THANK YOU FOR YOUR ORDER";

       Assert.assertTrue(thanksYaz1.getText().equalsIgnoreCase(thanksYaz2));
        Thread.sleep(3000);

       WebElement comeBack = driver.findElement(By.xpath("//button[@id='back-to-products']"));
       comeBack.click();

       String currentUrl = driver.getCurrentUrl();
       String expectedUrl = "https://www.saucedemo.com/inventory.html";
       Assert.assertEquals("URLs are not sama....", currentUrl,expectedUrl);
       if(currentUrl.equals(expectedUrl)) {
           System.out.println("they are same...");
       }
        Thread.sleep(3000);
       driver.quit();
    }

    public static List<String> elementToString(List<WebElement> list) {

        List<String> textList = new ArrayList<>();
        for (WebElement element : list) {
            textList.add(element.getText());

        }
        return textList;

    }

    public static void stringListControl(List<String> list1, List<String> list2) {
        for (int i = 0; i < list2.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                System.out.println(list1.get(i) + "urun sepette var...");
            }
            // Assert.assertEquals("Bilgiler Eslesmedi",list1.get(i),list2.get(i));
        }
    }

  public static double stringToDouble (String text) {
        String rakamText = text.replaceAll("[^0-9,.]","");
        // price.replaceAll("[^0-9, .]", "") yaparak sayılar ve nokta dısındaki herseyi
        // silme islemi.
        return Double.parseDouble(rakamText);
          }



}
