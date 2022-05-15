package day06_radioButton_Checklist;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C04_Assertions {
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
    public void test01(){
        /*Eger test methodumuzda hiçbir test yoksa, test çalıştıktan sonra
        hiçbir problemle karşılaşmadı ise, TEST PASSED olarak sonuç döner.
                 */
        driver.get("https://www.amazon.com/");
        //url'in facebook.com oldugunu test edin.

        /*if (driver.getCurrentUrl().equals("https://www.facebook.com")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        */

        String expectedUrl = "https://www.amazon.com/";
        String actualUrl   = driver.getCurrentUrl();

        //Eger iki URL birbirinden farklı ise, mesaj ve farklılıgı gösterir.
        Assert.assertEquals("url beklenenden farklı cıktı:", expectedUrl, actualUrl);
    }
}
