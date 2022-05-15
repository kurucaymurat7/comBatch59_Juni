package TekrarTesti;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1) Bir class oluşturun: YoutubeAssertions
public class YoutubeAssertions {
    static WebDriver driver;

    //2) https://www.youtube.com adresine gidin
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https:www.youtube.com");
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    @Test
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    public void titleTest(){
        Assert.assertEquals(driver.getTitle(), "YouTube");
    }

    @Test
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    public void imageTest(){
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
    }

    @Test
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    public void searchBoxTest(){
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
    }

    @Test
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    public void wrongTitleTest(){
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }
}
