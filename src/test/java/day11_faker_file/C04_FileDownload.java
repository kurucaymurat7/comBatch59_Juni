package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C04_FileDownload extends TestBase {

    //1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. dummy.txt dosyasını indirelim
    //4. dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test

    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        WebElement dummytxtLink = driver.findElement(By.xpath("//*[text()='dummy.txt']"));
        dummytxtLink.click();
        Thread.sleep(5000);

        //"C:\Users\HP\Downloads\dummy.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\dummy.txt";
        String arananDosyaYolu = farkliKisim + ortakKisim;

        //şimdi assert etmemiz gerekmektedir.

        Assert.assertTrue(Files.exists(Path.of(arananDosyaYolu)));

    }
}
