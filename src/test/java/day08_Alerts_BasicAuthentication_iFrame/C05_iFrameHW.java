package day08_Alerts_BasicAuthentication_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class C05_iFrameHW extends TestBase {

    @Test
    public void iFrameHW() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        String windowHandle1= driver.getWindowHandle();
        //2. “Our Products” butonuna basin
        Actions actions = new Actions(driver);
        WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(frame);
        WebElement ourProducts = driver.findElement(By.linkText("Our Products"));
        actions.click(ourProducts).perform();
        //3. “Cameras product”i tiklayin
        WebElement gameConsoles = driver.findElement(By.xpath("//div[@id='container-product4']"));
        WebElement cameras = driver.findElement(RelativeLocator.with(By.tagName("div")).above(gameConsoles));
        actions.click(gameConsoles).perform();
        //4. Popup mesajini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@class='modal-header']")).getText());
        //5. “close” butonuna basin
        Thread.sleep(5000);
        WebElement closeButton = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        closeButton.click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        WebElement webDriverUniversityElement = driver.findElement(By.xpath("(//a[@id='nav-title'])[1]"));
        actions.click(webDriverUniversityElement).perform();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
