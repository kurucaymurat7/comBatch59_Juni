package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel_Map {
    @Test
    public void readExcelTest() throws IOException {
        //// Excel dosyasindaki tüm verileri class'imiza alip
        //// bir java objesine store edelim
        //// boylece her seferinde excel'e ulasip satir sutun vs... ugrasmayalim

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        Map<String, String> ulkelerMap = new HashMap<>();
        for (int i = 0; i < sonSatirIndex; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            System.out.println(key);
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);

        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));
    }
}
