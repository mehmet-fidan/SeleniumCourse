package gun8;

import gun3._01_Try_Catch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class Css_Xpath_Child extends BaseStaticDriver {

    /**
     * Css
     * ul li  --> ul tagname altinda li olanlari verir.
     *
     * ul>li --> ul tagname altinda li olanlari verir.
     *
     * ul.social li:firt-child --> ilk child verir. --> ul[class='social'] li:first-child
     *
     * ul.social li:last-child --son child verir
     *
     * ul.social li:nth-child(2) --> listede istedigimiz child"i index ile verir
     */
    /**
     * Xpath
     * //ul/li --> ul tagname altinda li olanlari verir.
     *
     * //ul/li[1] ---> listenin ilk child"ini verir.
     * //ul[@class='social']/[1]
     *  //ul[@class='social']/[last()]
     *
     *
     */

    public static void main(String[] args) {


        _01_Try_Catch.login("standard_user","secret_sauce");

        WebElement facebook = driver.findElement(By.cssSelector("ul.social li:nth-child(2)"));
        System.out.println("facebook sayfasi :" +facebook.getText());
     //   facebook.click();

        WebElement linkedin = driver.findElement(By.xpath("//ul[@class='social']/li[last()]"));
        System.out.println(linkedin.getText());

        List<WebElement>  social = driver.findElements(By.xpath("//ul/li"));

        for (WebElement element : social) {
            System.out.println("listeleme :"+element.getText());
        }

    }
}
