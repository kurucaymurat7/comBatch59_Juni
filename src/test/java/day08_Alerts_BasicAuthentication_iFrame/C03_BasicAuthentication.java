package day08_Alerts_BasicAuthentication_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

    WebDriver driver;

    @Before
    public void tearUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test01(){
        //Burada basic authentication verileri girilerek sayfaya giriş yapıldı.
        //bu veriler ulaşılmak istenen website tarafından provide edilir.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
