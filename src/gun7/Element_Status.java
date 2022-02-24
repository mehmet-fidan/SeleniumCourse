package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class Element_Status extends BaseStaticDriver {

    /**
     * boolean isSelected(); --> secili mi
     * boolean isEnabled(); --> kullanilabiliyor mu
     * boolean isDisplayed(); --> gorunuyor mu
     * <p>
     * isSelected(); --> Wednesday --> true
     * <p>
     * isEnabled(); --> Monday  --> true
     * isEnabled(); --> Sunday --> false
     * <p>
     * isDisabled(); --> Monday --> true
     * isDisabled(); --> Sunday --> true
     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        Thread.sleep(3000);
        WebElement wednesday = driver.findElement(By.xpath("//input[@id='gwt-debug-cwCheckBox-Wednesday-input']"));
        System.out.println(wednesday.isEnabled());
        System.out.println(wednesday.isDisplayed());
        System.out.println("Secimden once: " + wednesday.isSelected()); // false

        wednesday.click();
        System.out.println("Secimden sonra: " + wednesday.isSelected()); //true
        System.out.println("*********");

        // List<WebElement> days = driver.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> getText = driver.findElements(By.xpath("//label[contains(@for,'gwt-debug-cwCheckBox-')]"));
        for (WebElement e : getText) {

            System.out.println(e.getText());
            System.out.println(e.isEnabled());
            System.out.println(e.isDisplayed());
            System.out.println(e.isSelected());
            System.out.println("*********");
        }


    }
}
