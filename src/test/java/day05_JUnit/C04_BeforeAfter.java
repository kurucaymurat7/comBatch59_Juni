package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {
    //Before ve After notasyonları her bir Test methodundan önce ve sonra olmak üzere birer defa çalıştırılır.
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
    public void Test01(){
        driver.get("https://www.amazon.com");
    }

    @Test
    public void Test02(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void Test03(){
        driver.get("https://www.facebook.com");
    }
}
