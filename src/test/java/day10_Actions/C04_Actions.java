package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    /*
    Yeni bir class olusturalim: MouseActions2
    1- https://demoqa.com/droppable adresine gidelim
    2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).perform();
        WebElement droppedWebElement = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String droppedText = droppedWebElement.getText();
        String expectedText = "Dropped!";
        Assert.assertEquals(expectedText, droppedText);
    }
}
