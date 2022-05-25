package day13_Cookies_WebTables;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Set;

public class D19_WebtablesHomework extends TestBase {
    @Test
    public void test01() {
        //Bir Class olusturun D19_WebtablesHomework

        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan department isimlerini yazdirin
        //WebElement table = driver.findElement(By.xpath("//div[@class='rt-tr']"));
        //System.out.println(table.getText());
        System.out.println("TASK 2: ");
        List<WebElement> headersDivList = driver.findElements(By.xpath("//div[@class='rt-tr']//div[@role='columnheader']"));

        int departmentIndex = 0;
        for (int i = 0; i < headersDivList.size(); i++) {
            if (headersDivList.get(i).getText().equals("Department")) {
                departmentIndex = i;
            }
        }
        departmentIndex++;
        List<WebElement> departmentsValuesList = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])//div[" + departmentIndex + "]"));
        for (int i = 0; i < departmentIndex; i++) {
            if (!departmentsValuesList.get(i).getText().equals(" ")) {
                System.out.println(departmentsValuesList.get(i).getText());
            }
        }

        //  3. sutunun basligini yazdirin
        System.out.println("TASK 3: ");
        System.out.print("3. sutun basligi: ");
        System.out.println(headersDivList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("TASK 4");
        System.out.println("1. yontem: ");
        WebElement tumtTableWebElement = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("tum datalar");
        System.out.println(tumtTableWebElement.getText());

        //2. yontem....
        int tableSatirSayisi = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])")).size();
        int tumTableHucreSayisi = driver.findElements(By.xpath("(//div[@class='rt-tbody'])//div[@class='rt-td']")).size();
        int satirHucreSayisi = tumTableHucreSayisi / tableSatirSayisi;
        List<WebElement> tumCellBilgileri = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']"));
        System.out.println("2. yontem: ");
        for (int i = 0; i < tumCellBilgileri.size(); i++) {
            if (i > satirHucreSayisi && i % satirHucreSayisi == 0) {
                System.out.println();
            }
            System.out.print(tumCellBilgileri.get(i).getText() + "   ");
        }

        //3.yontem
        //(//div[@class='rt-tr-group'][1]//div[@class='rt-td'])[3]
        System.out.println();
        System.out.println("3. yontem: ");
        for (int satir = 1; satir <= tableSatirSayisi; satir++) {
            for (int hucre = 1; hucre <= satirHucreSayisi; hucre++) {
                WebElement istenenHucre = driver.findElement(By.xpath("(//div[@class='rt-tr-group'][" + satir + "]//div[@class='rt-td'])[" + hucre + "]"));
                System.out.print(istenenHucre.getText() + "   ");
            }
            System.out.println("");
        }

        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("TASK 5: ");
        List<WebElement> tablodakiCellList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']"));
        System.out.println("Tablodaki Cell Sayisi : " + tablodakiCellList.size());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("TASK 6: ");
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])"));
        System.out.println("Table'daki satır sayısı : " + tumSatirlar.size());

        //  7. Tablodaki sutun sayisini yazdirin
        // 1. yontem:
        System.out.println("TASK 7: ");
        System.out.println("1. yontem: ");
        int sutunSayisi = tablodakiCellList.size() / tumSatirlar.size();
        System.out.println("Sutun sayisi : " + sutunSayisi);

        //2.yontem:
        System.out.println("2. yontem: ");
        List<WebElement> ilkSatirBilgileriList = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])[1]//div[@class='rt-td']")); // bir satirdaki rt-td sayisi
        System.out.println("Sutun sayisi : " + ilkSatirBilgileriList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println("TASK 8: ");
        //(//div[@class='rt-tr-group'])[1]//div[3]
        for (int i = 1; i <= tableSatirSayisi; i++) {
            if (!driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[3]")).getText().equals(" ")) {
                System.out.print(i + ". satir 3. sutun : ");
                System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[3]")).getText() + " ");
            }
        }

        ////  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("TASK 9 : ");
        System.out.print("Kierra Salary : ");
        for (int i = 1; i <= tableSatirSayisi; i++) {
            if (driver.findElement(By.xpath("((//div[@class='rt-tr-group'])[" + i + "]//div[1])[2]")).getText().equals("Kierra")) {
                System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[5]")).getText());
            }
        }

        // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println("TASK 10 : ");
        int satir = 2;
        int sutun = 2;
        satirSutunYazdir(satir, sutun);
    }

    private void satirSutunYazdir(int satir, int sutun) {
        System.out.println("10. task: ");
        WebElement istenenHucre = driver.findElement(By.xpath("(//div[@class='rt-tr-group'][" + satir + "]//div[@class='rt-td'])[" + sutun + "]"));
        System.out.print("satir. " + satir + " sutun. " + sutun + " : " + istenenHucre.getText() + "      ");
    }

}
