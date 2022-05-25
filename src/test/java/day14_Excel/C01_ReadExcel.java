package day14_Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void name() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10.WorkbookFactory.create(fileInputStream)

        Workbook workbook = WorkbookFactory.create(fis);

        //11. Sheet objesi olusturun workbook.sheetAt(index)
        //workbook.getSheetAt(index)
        Sheet sheet =  workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun
        //sheet.getRow(index)
        //index 0'dan başlar.
        Row row = sheet.getRow(3);

        //13. Cell objesi olusturun
        //row.getCell(index)
        Cell cell = row.getCell(3);

        System.out.println(cell);
        String actualData = cell.toString();
        actualData = cell.getStringCellValue(); // bu şekilde de olabilir.

        //3. index 3. satir data Cezayir mi ?
        String expectedData = "Cezayir";
        Assert.assertEquals(expectedData, actualData);
    }
}