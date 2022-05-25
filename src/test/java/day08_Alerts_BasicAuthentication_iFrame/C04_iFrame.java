package day08_Alerts_BasicAuthentication_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_iFrame {
    // ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
    //        ○ Text Box’a “Merhaba Dunya!” yazin.
    //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.

    WebDriver driver;

    @Before
    public void tearUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).isEnabled());

        //önce iframe locate edilmeli.
        //bir website içerisinde bulunan bir iframe içindeki herhangi bir öğeye erişim yapabilmek için
        //öncelikle, driver'ımızı o iframe'e locate etmeliyiz.
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);

        //driver, iframe'e locate edildikten sonra iframe içerisindeki bir webElement'e erişim yapılabilir.
        WebElement textKutusu = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dünya");

        driver.switchTo().defaultContent(); // Ana sayfaya geri dönüş yapar.
        //driver.switchTo().parentFrame(); //bulunduğu frame'in bir üstündeki parent frame'e geçiş yapar.

        WebElement linkYaziElementi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
