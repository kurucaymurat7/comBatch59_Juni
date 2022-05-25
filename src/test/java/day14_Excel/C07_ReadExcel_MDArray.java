package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C07_ReadExcel_MDArray {
    @Test
    public void readExcelTest() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum() + 1;

        //kullanilan sutun sayisini bulmak icin ilk satiri hucre hucre gezip " " boş hucre bulunca sutun sayisi elde ederiz.
        int sutunSayisi = 0;
        try {
            while (true) {
                if (workbook.getSheet("Sayfa1").getRow(0).getCell(sutunSayisi).toString().equals(" ")) {
                    break;
                } else {
                    sutunSayisi++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("satır sonuna gelindi."); // null pointer exception firlatmasini onlemek icin
        }

        System.out.println("Satir sayisi : " + satirSayisi); //satir sayisi
        System.out.println("Sutun sayisi : " + sutunSayisi); //sutun sayisi


        String[][] arrayMDExcel = new String[satirSayisi][sutunSayisi];
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                arrayMDExcel[i][j] = workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString();
            }
        }

        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                System.out.printf("%-50s", arrayMDExcel[i][j]);
            }
            if (i == 0) {
                System.out.println();
                System.out.println("=======================================================" +
                        "=====================================================================" +
                        "===========================================================");
            } else {
                System.out.println();
            }
        }

        //Afganistan'ın Türkçe başkent ismi nedir ?

        for (int i = 0; i < satirSayisi; i++) {
            if (arrayMDExcel[i][0].equals("Afghanistan")) {
                System.out.println("Tükçe Başkenti : " + arrayMDExcel[i][3]);
            }
        }
    }
}