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

import java.time.Duration;
import java.util.List;

public class MetroTur {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

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
           // System.out.println("Seçilen  = " + (i+1) + ".koltuk = " + bosKoltuklar.get(i).getText());
        }
        bekle(2);

        //ekranda açılan alert penceresini kapat.
        driver.switchTo().alert().accept();
        //Dönüş seferi seç butonuna tıkla.
        driver.findElement(By.xpath("(//*[@id='btnChooseReturnJourney'])[1]")).click();


        //  locate ==>     (//*[@class="btn btn-select ngSelectJourneyReturn"])[1]

    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}