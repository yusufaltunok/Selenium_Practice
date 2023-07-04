package odevler;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class excelReadWrite {
    @Test
    public void test01() throws IOException {

//ODEV1
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

   // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());

   // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1sutun2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("1. Satır 2. sütun : "+satir1sutun2);

   // 2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String satir2Sutun4 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println("2. Satır 4. Sütun değeri : " + satir2Sutun4);
        Assert.assertEquals("Kabil",satir2Sutun4);

   // Satir sayisini bulalim
        System.out.println("Satır sayısı : " + workbook.getSheet("Sayfa1").getLastRowNum());

    // Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Kullanılan satır sayısı : "+ workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

   // Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map <String,String> ulkeBaskent = new LinkedHashMap<>();

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            String ulke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,baskent+  "\n");
        }
        System.out.println(ulkeBaskent);



    }

    @Test
    public void writeExcelTest() throws IOException {
        //ODEV2
        //    Yeni bir test method olusturalim writeExcelTest()
        //    Adimlari takip ederek 1.satira kadar gidelim
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        //    5.hucreye yeni bir cell olusturalim
        //    Olusturdugumuz hucreye "Nufus" yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");

        //    2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);

        //    10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);

        //    15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(54000);

        //    Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream("src/test/java/resources/ulkeler.xlsx");
        workbook.write(fos);

        //    Dosyayi kapatalim
        fos.close();
        workbook.close();

    }


}
