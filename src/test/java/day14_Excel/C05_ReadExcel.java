package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIndex = workbook.
                getSheet("Sayfa2").
                getLastRowNum();
        System.out.println(sonSatirIndex); // en son kullanilan satir index değeri verir.

        int kullanilanSatirSayisi = workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows(); //aktif olarak kullanilan satir sayisini verir.
        System.out.println(kullanilanSatirSayisi);
    }
}
