package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        //iicinde olunan projenin dosya yolunu verir.
        System.out.println(System.getProperty("user.dir"));

        //bu da, bilgisayarın bize özel kısmını verdi.
        System.out.println(System.getProperty("user.home"));
        //C:\Users\HP\

        //C:\Users\HP\Downloads
        //C:\Users\HP\Desktop
        //C:\Users\HP\IdeaProjects\com.Batch59JUnit\src\test\java\day05_JUnit

        //masaüstündeki text dosyasının varlığını test edin.
        //"C:\Users\HP\OneDrive\Masaüstü\text.txt"

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        // System.getProperty("user.home"), bu kısım her bilgisayarda farklıdır.
        // O yüzden bu kısmı dinamik olarak alıyoruz.

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\text.txt";
        //"C:\Users\HP\OneDrive\Masaüstü\text.txt"
        String masaustuDosyaYolu = farkliKisim + ortakKisim;
        System.out.println(masaustuDosyaYolu);

        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}
