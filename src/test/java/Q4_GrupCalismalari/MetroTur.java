package Q4_GrupCalismalari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MetroTur extends TestBase {


    @Test
    public void test() {
        Actions actions;
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

        //gidis tarihine o günün tarihi sec
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[1]")).click();
        WebElement secilenTarih = driver.findElement(By.xpath("//*[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']"));
        System.out.println("gidis tarihi : " +secilenTarih.getText());
        int intGidisTarihi = Integer.parseInt(secilenTarih.getText());
        int nowDay = LocalDate.now().getDayOfMonth();
        System.out.println("nowDay = " + nowDay);
        secilenTarih.click();
        Assert.assertEquals(nowDay, intGidisTarihi);

        //donus tarihini o günün tarihi sec
        driver.findElement(By.xpath("(//*[@class='fa fa-calendar'])[2]")).click();
        WebElement donustarihi = driver.findElement(By.xpath("//*[@class=\"  ui-datepicker-today\"]"));
        System.out.println("dönüstarihi : "+donustarihi.getText());
        int intdonusTarihi2 = Integer.parseInt(donustarihi.getText());
        int nowDay1 = LocalDate.now().getDayOfMonth();
        System.out.println("nowDay1 = " + nowDay1);
        donustarihi.click();
        Assert.assertEquals(nowDay1, intdonusTarihi2);

        //Listele'ye tıkla
        driver.findElement(By.id("btnIndexSearchJourneys")).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //Gidiş seferleri için en üstteki 3 butonun çalıştığını kontrol et


        List<WebElement> secButonlari;
        for (int i = 0; i < 4; i++) {
            secButonlari = driver.findElements(By.xpath("//*[@class='btn btn-select ngSelectJourney']"));
            secButonlari.get(i).click();
            bekle(2);
            WebElement koltukSecYazisi = driver.findElement(By.xpath("(//*[text()='Lütfen bir koltuk seçiniz'])[1]"));
            //System.out.println((i + 1) + " .Sefer icin  " + koltukSecYazisi.getText());
            Assert.assertTrue(koltukSecYazisi.isDisplayed());
            bekle(2);
            //driver.findElement(By.xpath("(//*[text()='Kaldır'])[i+1]")).click();

        }

        List<WebElement> bosKoltuklar = driver.findElements(By.xpath("//*[@ng-if='!col.isSold']"));
        for (int i = 0; i < 1; i++) {
            bosKoltuklar = driver.findElements(By.xpath("//*[@ng-if='!col.isSold']"));
            bosKoltuklar.get(i).click();
            bekle(2);
            actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            System.out.println("Gidiş Seçilen koltuk No = " + bosKoltuklar.get(i).getText());
        }
        bekle(2);
        /*
        //ekranda açılan alert penceresini kapat.
        driver.switchTo().alert().accept(); burayı yoruma aldık çünkü 1 yolcu için alert mesajı gelmeyecek.
        */
        //Dönüş seferi seç butonuna tıkla.
        driver.findElement(By.xpath("(//*[@id='btnChooseReturnJourney'])[1]")).click();

        //En üstteki sefere tıkla.
        driver.findElement(By.xpath("(//*[@class='btn btn-select ngSelectJourneyReturn'])[1]")).click();
        bekle(2);
        //1 tane boş koltuk seç
        /*
        //*[@ng-click="selectSeat(col,'true','true','false')"]  ==> Boş koltukların listinin tutulduğu locate
         */
        List<WebElement> bosKoltuklarim;
        for (int i = 0; i < 1; i++) {
            bosKoltuklarim = driver.findElements(By.xpath("//*[@ng-click=\"selectSeat(col,'true','true','false')\"]"));
            bosKoltuklarim.get(i).click();
            System.out.println("Dönüş Seçilen koltuk No = " + bosKoltuklarim.get(i).getText());
            bekle(2);

        }
        bekle(3);
        //ödeme sayfasına geç'e tıkla.
        driver.findElement(By.xpath("(//*[@id='btnDoPaymentPage'])[2]")).click();
        bekle(3);
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        //String kalkisTarihi = driver.findElement(By.xpath("(//tbody//tr//span)[3]")).getText();
        String kalkisTarihi = driver.findElement(By.cssSelector("[id='spanBoarding']")).getText();

        System.out.println("Kalkış Tarihi " + kalkisTarihi);

        String[] arr = kalkisTarihi.split("\\.");//16.06.2023 21:30
        System.out.println(Arrays.toString(arr));//[16.06.2023, 21:30]
        int ilk = Integer.valueOf(arr[0]);

        int ayinKaciniGunu = LocalDate.now().getDayOfMonth();
        Assert.assertEquals(ilk, ayinKaciniGunu);


    }

}