package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // Ingilizce baskentler sutunu yazdir.
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        String satirdakiData = "";
        System.out.println(sonSatirIndex);
        for (int i = 0; i <= sonSatirIndex; i++) {
            satirdakiData = C03_ReadExcel.banaDataGetir(i, 1);
            System.out.println(satirdakiData);
        }
    }
}
