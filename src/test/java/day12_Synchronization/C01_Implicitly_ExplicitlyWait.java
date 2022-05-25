package day12_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import java.time.Duration;

public class C01_Implicitly_ExplicitlyWait extends TestBase {
    // 1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //   Iki metod icin de asagidaki adimlari test edin.

    //Implicit ve Explicit testi arasındaki fark:
    // Implicit, net bir bekleme süresi kadar bekletirken;
    // Explicit, bir condition'a bagli olarak condition true donene kadar bekler.

    @Test
    public void implicitWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
    }

    @Test
    public void explicitlywaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        */
        //Yazının gorunur olmasını beklerken, onu locate etmek mantıklı olmaz ve hata verir.
        //Bu nedenle wait ve locate islemi aynı anda ve icice yapilmalidir.
        //HTML kodları yazan developer farklı uygulamalar yapılabilir.
        WebElement element = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(element.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());
    }
}
