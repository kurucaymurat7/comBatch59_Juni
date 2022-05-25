package day09_WindowHandling_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandles {

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
        driver.quit();
    }

    @Test
    public void test01(){
        /*
        amazona git
        urlin amazon içerdiğini  test et
        yeni bir pencerede bestbuya git
        title'ın BestBuy içerdiğini test et
        ilk sayfaya dön ve sayfada java arat
        arama sonuçlarının java içerdiğini test et
        yeniden bestbuy'ın açık olduğu sayfaya git
        logonun visible olduğunu test et
         */

        //amazona git
        driver.get("https://www.amazon.com");
        String amazonSayfaHandleDegeri= driver.getWindowHandle();

        //urlin amazon içerdiğini  test et
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //yeni bir pencerede bestbuya git
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuySayfaHandleDegeri= driver.getWindowHandle();

        //title'ın BestBuy içerdiğini test et
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        //ilk sayfaya dön ve sayfada java arat
        driver.switchTo().window(amazonSayfaHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        //arama sonuçlarının java içerdiğini test et
        String bulunanSonuc = driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
        String arananKelime = "Java";
        Assert.assertTrue(bulunanSonuc.contains(arananKelime));

        //yeniden bestbuy'ın açık olduğu sayfaya git
        driver.switchTo().window(bestBuySayfaHandleDegeri);

        //logonun visible olduğunu test et
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
