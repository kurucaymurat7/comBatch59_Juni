package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.openqa.selenium.Keys.*;

public class C01_faker extends TestBase {

    // Bu projede FAKER kütüphanesini kullanacagiz.

    @Test
    public void test() throws InterruptedException {
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate edip,
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        Actions actions= new Actions(driver);
        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(TAB)
                .sendKeys(fakeEmail)
                .sendKeys(TAB)
                .sendKeys(fakeEmail)
                .sendKeys(TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(TAB)
                .sendKeys(TAB)
                .sendKeys("Jan")
                .sendKeys(TAB)
                .sendKeys("15")
                .sendKeys(TAB)
                .sendKeys("2000")
                .sendKeys(TAB)
                .sendKeys(TAB)
                .sendKeys(ARROW_DOWN)
                .sendKeys(TAB)
                .sendKeys(TAB)
                .sendKeys(TAB)
                .sendKeys(TAB)
                .sendKeys(ENTER)
                .perform();
        Thread.sleep(15000);
    }
}
