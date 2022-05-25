package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){
        /*
            1- Yeni bir class olusturalim: MouseActions1
            2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
            3- Cizili alan uzerinde sag click yapalim
            4- Alert’te cikan yazinin “You selected a context menu” oldugunu
                test edelim.
            5- Tamam diyerek alert’i kapatalim
            6- Elemental Selenium linkine tiklayalim
            7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         */

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement alticiziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(alticiziliAlan).perform();
        String expectedYazi = "You selected a context menu";
        String alertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, alertYazisi);
        driver.switchTo().alert().accept();
        String ilksayfaHandleDegeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSet= driver.getWindowHandles();
        String yeniSayfaHandleDegeri = "";
        for (String each:handleSet) {
            if (!each.equals(ilksayfaHandleDegeri)){
                yeniSayfaHandleDegeri = each;
            }
        }
        driver.switchTo().window(yeniSayfaHandleDegeri);
        String h1ActualYaziDegeri = driver.findElement(By.tagName("h1")).getText();
        String h1expectedYaziDegeri = "Elemental Selenium";
        Assert.assertEquals(h1expectedYaziDegeri,h1ActualYaziDegeri);
    }
}












