package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test

    public void test01() throws InterruptedException {
        //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2.https://the-internet.herokuapp.com/upload adresine gidelim
        //3.chooseFile butonuna basalim
        //4.Yuklemek istediginiz dosyayi secelim.
        //5.Upload butonuna basalim.
        //6.“File Uploaded!” textinin goruntulendigini test edelim.

        driver.get("https://the-internet.herokuapp.com/upload");
        //SendKeys() methoduna dosya yolu yollarsak, dosya otomatik olarak upload edilecektir.
        WebElement DosyaSecButtonu = driver.findElement(By.xpath("//input[@id='file-upload']"));
        //Dosya Sec butonuna bas.
        //yuklenecek dosyanın dosya yolunu olusturalım.
        String farkiKisim = System.getProperty("user.home");
        //"C:\Users\HP\OneDrive\Masaüstü\text.txt"
        String ortakKisim = "\\OneDrive\\Masaüstü\\text.txt";
        String yuklenecekDosya = farkiKisim + ortakKisim;
        //sendKeys ile dosya yolunu secme butonuna yollayalım.
        DosyaSecButtonu.sendKeys(yuklenecekDosya);

        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();

        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        Thread.sleep(5000);


    }
}
