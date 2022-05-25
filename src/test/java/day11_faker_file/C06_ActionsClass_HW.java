package day11_faker_file;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_ActionsClass_HW extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hovermeFirst = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        actions.clickAndHold(hovermeFirst).perform();
        //3. "Link 1" e tiklayin
        WebElement link1WebElement = driver.findElement(By.xpath("//a[text()='Link 1']"));
        actions.click(link1WebElement).perform();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldKutusu = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldKutusu).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldKutusu.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickmeButton = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClickmeButton).perform();
        //Thread.sleep(5000);
    }

}
