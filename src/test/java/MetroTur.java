import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class MetroTur extends TestBase {


    @Test
    public void test() {
        //1)   metroturizm sitesine git
        driver.get("https://www.metroturizm.com.tr/");
        //Sayfa acildiginda Gidiş Dönüş radio button'a tikla.
        driver.findElement(By.xpath("//*[@for='radio02']")).click();

        //nereden ddm ye gel 2 indexli olani sec

        WebElement ddm = driver.findElement(By.xpath("(//select)[1]"));
        Select select = new Select(ddm);
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

        //nereye ddm den 14 indexli olani (ANKARA) yi sec
        WebElement ddmNereye = driver.findElement(By.xpath("(//select)[2]"));
        Select selectNereye = new Select(ddmNereye);
        selectNereye.selectByIndex(14);

        //gidis tarihine 15.06.2023 sec
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[1]")).click();
        WebElement secilenTarih = driver.findElement(By.xpath("//*[text()='15']"));
        secilenTarih.click();

        //donus tarihini 18.06.2023 olarak isaretle
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[2]")).click();
        driver.findElement(By.xpath("//*[text()='18']")).click();

        //Listele'ye tıkla
        driver.findElement(By.id("btnIndexSearchJourneys")).click();

        //Gidiş seferleri için en üstteki 3 butonun çalıştığını kontrol et


        List<WebElement> secButonlari = driver.findElements(By.xpath("//*[@class='btn btn-select ngSelectJourney']"));
        for (int i = 0; i < 3; i++) {
            secButonlari = driver.findElements(By.xpath("//*[@class='btn btn-select ngSelectJourney']"));
            secButonlari.get(i).click();
            bekle(2);
            WebElement koltukSecYazisi = driver.findElement(By.xpath("(//*[text()='Lütfen bir koltuk seçiniz'])[1]"));
            System.out.println((i + 1) + " .Sefer = " + koltukSecYazisi.getText());
            Assert.assertTrue(koltukSecYazisi.isDisplayed());
            bekle(2);
           // driver.findElement(By.xpath("(//*[text()='Kaldır'])[i+1]")).click();

        }

        List<WebElement> bosKoltuklar = driver.findElements(By.xpath("//*[@ng-if='!col.isSold']"));
        for (int i = 0; i < 5; i++) {
            bosKoltuklar = driver.findElements(By.xpath("//*[@ng-if='!col.isSold']"));
            bosKoltuklar.get(i).click();
          //  System.out.println("Seçilen  = " + (i+1) + ".koltuk = " + bosKoltuklar.get(i).getText());
        }
        bekle(2);

        //ekranda açılan alert penceresini kapat.
        driver.switchTo().alert().accept();
        //Dönüş seferi seç butonuna tıkla.
        driver.findElement(By.xpath("(//*[@id='btnChooseReturnJourney'])[1]")).click();

        // Açılan menüden en üstteki seç'e tıkla
        driver.findElement(By.xpath("(//*[@class='btn btn-select ngSelectJourneyReturn'])[1]")).click();
        bekle(2);

        List<WebElement> bosKoltukDonus ;
        for (int i = 0; i < 5; i++) {
            bosKoltukDonus = driver.findElements(By.xpath("(//i[@class='icon-seat-empty']) [position()>=29 and position()<=58]"));
            bosKoltukDonus.get(i).click();
        //    System.out.println("Seçilen  = " + (i+1) + ".koltuk = " + bosKoltuklar.get(i).getText());

        }
        //ekranda açılan alert penceresini kapat.
        driver.switchTo().alert().accept();

        //"Dönüş Seferi Seç" butonuna tıkla
        driver.findElement(By.xpath("(//*[@id='btnChooseReturnJourney'])[2]")).click();

        // " Ödeme Sayfasına Geç" butonuna tıkla
        driver.findElement(By.xpath("(//*[@id='btnDoPaymentPage'])[2]")).click();

        //
        WebElement cinsiyet1 = driver.findElement(By.xpath("selGender9"));
        WebElement cinsiyet2 = driver.findElement(By.xpath("selGender8"));
        WebElement cinsiyet3 = driver.findElement(By.xpath("selGender4"));
        WebElement cinsiyet4 = driver.findElement(By.xpath("selGender12"));

        Select select1 = new Select(cinsiyet1);
        Select select2 = new Select(cinsiyet2);
        Select select3 = new Select(cinsiyet3);
        Select select4 = new Select(cinsiyet4);

        select1.selectByIndex(1);
        select2.selectByIndex(1);
        select3.selectByIndex(0);
        select4.selectByIndex(0);

    }



}