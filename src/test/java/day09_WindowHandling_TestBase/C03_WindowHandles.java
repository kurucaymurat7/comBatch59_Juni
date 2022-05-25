package day09_WindowHandling_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        //    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        /*
        Eğer kontrolsüz olarak açılan bir window var ise,
        sayfaların windowHandle değerini elde etmeliyiz..
        öncelikle 2.sayfa açılmadan önce,
        ilk sayfanın windowHandle değerini bir stringe atayalım.
         */

        String ilksayfaHandleDegeri = driver.getWindowHandle();

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> tümSayfalarHandleDegerleri = driver.getWindowHandles();

        String ikiciSayfaHandleDegeri = "";
        for (String each:tümSayfalarHandleDegerleri) {
            if(each!=ilksayfaHandleDegeri){
                ikiciSayfaHandleDegeri = each;
            }
        }

        driver.switchTo().window(ikiciSayfaHandleDegeri);

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //Sayfadaki textin “New Window” olduğunu doğrulayın.

        String expectedSecondTitle = "New Window";
        String actualSecondTitle = driver.getTitle();
        Assert.assertEquals(expectedSecondTitle,actualSecondTitle);

        WebElement ikincisayfaYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedİkinciYazi = "New Window";
        String actualİkinciYazi = ikincisayfaYaziElementi.getText();
        Assert.assertEquals(expectedİkinciYazi, actualİkinciYazi);

        driver.switchTo().window(ilksayfaHandleDegeri);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }
}
