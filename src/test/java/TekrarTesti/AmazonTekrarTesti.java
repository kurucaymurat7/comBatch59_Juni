package TekrarTesti;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.pqc.jcajce.provider.QTESLA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1-C01_TekrarTesti isimli bir class olusturun
//2- https://www.amazon.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi “refresh” yapin
//5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
//6- Gift Cards sekmesine basin
//7- Birthday butonuna basin
//8- Best Seller bolumunden ilk urunu tiklayin
//9- Gift card details’den 25 $’i secin
//10-Urun ucretinin 25$ oldugunu test edin
//10-Sayfayi kapatin

public class AmazonTekrarTesti {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void Test(){
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        if (driver.getTitle().contains("Spend less")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.findElement(By.linkText("Gift Cards")).click();
        driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[28]")).click();
        driver.findElement(By.xpath("(//span[@class='nav-a-content'])[2]")).click();
        driver.findElement(By.xpath("(//img[@class='a-dynamic-image p13n-sc-dynamic-image p13n-product-image'])[1]")).click();
        WebElement giftCard25 =  driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]"));
        giftCard25.click();
        if (giftCard25.getText().equals("$25")){
            System.out.println("Gift card test passed");
        } else {
            System.out.println("Gift Card test failed");
        }
        driver.close();
    }
}
