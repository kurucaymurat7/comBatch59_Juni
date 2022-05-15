package day06_radioButton_Checklist;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterClass {
    //BeforeClass ve AfterClass notasyonlari sadece static methodlar için kullanılmalıdır.
    //BeforeClass ve AfterClass en başta ve en sonda bir defa olmak üzere çalıştırılır.
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
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
