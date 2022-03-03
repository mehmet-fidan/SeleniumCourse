package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_ActionClass_HoverOver extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.etsy.com/");

       /* WebElement clothesAndShoes = driver.findElement(By.xpath("//span[@id='catnav-primary-link-10923']"));
        WebElement kidsAndBaby = driver.findElement(By.xpath("//span[@id='side-nav-category-link-10941']"));
        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        Action git1 = builder.moveToElement(clothesAndShoes).build();
        git1.perform();
        Thread.sleep(2000);
        Action git2 = builder.moveToElement(kidsAndBaby).build();
        git2.perform();
        driver.quit();

        */


        List<WebElement> menuBar = driver.findElements(By.cssSelector("ul[class='wt-list-unstyled wt-grid__item-xs-12 wt-body-max-width wt-display-flex-xs wt-justify-content-space-between'] li"));

        Actions builder = new Actions(driver);

        Action git3;

        for (WebElement listGit : menuBar) {
            git3 = builder.moveToElement(listGit).build();
            git3.perform();
            Thread.sleep(2000);
        }

        Thread.sleep(2000);
        driver.quit();




        /*
        https://www.birtwhistle.com/workers-compensation-insurance/
        Ödev Menu yü liste yaparak Hover _Over ile dolasiniz
         */






    }
}
