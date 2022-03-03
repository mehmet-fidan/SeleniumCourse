package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class Hover_Over extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.etsy.com/");

        List<WebElement> menuBar = driver.findElements(By.cssSelector("ul[class='wt-grid wt-grid--block wt-justify-content-center wt-pt-xs-1 wt-pl-xs-1 wt-pr-xs-1 wt-pt-md-0 wt-pl-md-4 wt-pr-md-4 wt-pl-lg-6 wt-pr-lg-6'] a"));
        Thread.sleep(2000);
        Actions builder = new Actions(driver);

        Action git;
        for (WebElement lisyGit : menuBar) {
            git = builder.moveToElement(lisyGit).build();
            git.perform();
            Thread.sleep(1000);
        }

        WebElement onSale = driver.findElement(By.linkText("On Sale"));
        onSale.click();


        Thread.sleep(2000);

        driver.quit();


    }
}
