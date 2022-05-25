package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    /*Actions class'ı ile mouse ve klavye ile her işlemi yapabiliriz.
      çift tıklama
      drag drop
      hareket ettirme
     */
    @Test
    public void test01() throws InterruptedException {
        //1.adım: driver'ı parametre olarak actions'a ekle
        //amazon'a git
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        //2.adım: webelement ogesini locate et
        WebElement accountLink = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute']"));
        //3.adım: actions ile islem yaparken perform() kullanmak zorundayız.
        actions.moveToElement(accountLink).perform();
        WebElement createList = driver.findElement(By.xpath("//*[text()='Create a List']"));
        actions.moveToElement(createList).click().perform();
        Thread.sleep(5000);
    }
}
