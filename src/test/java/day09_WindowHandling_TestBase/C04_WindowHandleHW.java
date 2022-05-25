package day09_WindowHandling_TestBase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;
import java.util.stream.Collectors;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

public class C04_WindowHandleHW extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String windowHanlde1 = driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(TAB).perform();
        //3."Login Portal" a tiklayin
        WebElement loginPortal = driver.findElement(By.xpath("(//h1)[3]"));
        actions.click(loginPortal).perform();
        //4.Diger window'a gecin
        Set<String> allWindowHandles = driver.getWindowHandles();
        String windowHandle2 = allWindowHandles.stream().filter(t->!t.equals(windowHanlde1)).collect(Collectors.toList()).get(0);
        driver.switchTo().window(windowHandle2);
        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin
        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@id='text']"));
        Faker faker = new Faker();
        actions.sendKeys(userNameTextBox, faker.name().fullName())
                .sendKeys(TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(TAB)
                .sendKeys(ENTER)
                .perform();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "validation failed";
        Assert.assertEquals(expectedText, actualText);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(windowHanlde1);
        //10.Ilk sayfaya donuldugunu test edin
        String ilkSayfaWindowHandle = windowHanlde1;
        String currentWindowHandle = driver.getWindowHandle();
        Assert.assertEquals(ilkSayfaWindowHandle, currentWindowHandle);
        Thread.sleep(5000);
    }
}
