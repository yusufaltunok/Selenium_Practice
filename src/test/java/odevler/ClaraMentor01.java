package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClaraMentor01 {
      /*

    /*Exercise1... Q1 altında yeni bir sınıf oluştur ana yöntemi oluştur
    Yolu Ayarla Krom sürücüsü oluştur Pencereyi büyüt Google ana sayfasını aç
     https:www.google.com. Aynı sınıfta, Amazon ana sayfasına gidin
     https:www.amazon.com Google'a geri gidin Amazon'a ilerleyin Sayfayı yenileyin
     Kapat Tarayıcıdan çıkın Ve son adım: konsolda "tamam" yazdırın
    */
      WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        driver.get("http://google.com/");
        driver.get("http://amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        System.out.println("tamam");
    }
}
