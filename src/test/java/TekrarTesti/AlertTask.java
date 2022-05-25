package TekrarTesti;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AlertTask {

    //https://testpages.herokuapp.com/styled/alerts/alert-test.html

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-pop-up-blocking");
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        driver.findElement(By.xpath("(//input[@class='styled-click-button'])[1]")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@class='styled-click-button'])[2]")).click();
        driver.switchTo().alert().dismiss();

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@class='styled-click-button'])[3]")).click();
        driver.switchTo().alert().sendKeys("Murat Kuruçay");
        driver.switchTo().alert().accept();
        String sonucYaziElement = driver.findElement(By.xpath("(//*[text()='Murat Kuruçay'])[1]")).getText();
        Assert.assertTrue(sonucYaziElement.contains("Murat Kuruçay"));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
