package practice;

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

import java.time.Duration;

public class KitapYurdu {



//    1	www.kitapyurdu.com sitesine git
//2	Arama motorunda java ara
//3	Arama sonuçlarının java ile ilgili olduğunu doğrula
//4	En üstteki ürünün başlığına tıkla
//5	Seçilen ürünün sayfasının açıldığını doğrula
//6	Sepete ekle butonuna tıkla
//7	Sepetinizde butonun göründüğünü doğrula
//8	Sağ üst köşedeki Sepetim butonuna tıkla
//9	Açılan menüdeki sepete git butonuna tıkla
//10	Sepetim sayfasının açıldığını doğrula
//11	Seçilen ürünün sepette olduğunu doğrula
//1:39
//        1	www.kitapyurdu.com sitesine git
//2	Sağ üst köşedeki Sepetim butonuna tıkla
//3	Açılan menüdeki sepete git butonuna tıkla
//4	Sepetim sayfasının açıldığını doğrula
//5	Seçilen ürünün sepette olduğunu doğrula
//6	Sepetteki ürünü seç
//7	Sepetteki ürünü silmek için "x" butonuna tıkla.
//            8	Sepetteki ürünün silindiğini doğrula.
//
WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://kitapyurdu.com");
    }
    @Test
    public void test01() {
        driver.findElement(By.cssSelector("[id='search-input']")).sendKeys("java", Keys.ENTER);
        //3	Arama sonuçlarının java ile ilgili olduğunu doğrula
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(sonucYazisi.getText().contains("java"));
        bekle(2);
        //4	En üstteki ürünün başlığına tıkla
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='cover'])[2]"));
        String expectedTitle = ilkUrun.getText();
        String actualTitle = driver.getTitle();

        ilkUrun.click();

        //5	Seçilen ürünün sayfasının açıldığını doğrula
        Assert.assertTrue(actualTitle.contains(expectedTitle));

//6	Sepete ekle butonuna tıkla
        driver.findElement(By.cssSelector("[id=button-cart]")).click();

//7	Sepetinizde butonun göründüğünü doğrula
        WebElement sepetinizde =driver.findElement(By.xpath("(//*[text()='Sepetinizde'])[2]"));
        Assert.assertTrue(sepetinizde.isDisplayed());
//8	Sağ üst köşedeki Sepetim butonuna tıkla
        driver.findElement(By.xpath("(//h4)[1]")).click();

//9	Açılan menüdeki sepete git butonuna tıkla
        driver.findElement(By.id("js-cart")).click();

//10	Sepetim sayfasının açıldığını doğrula
        String actualTitle1 = driver.getTitle();
        Assert.assertEquals(actualTitle1,"Sepetim");

//11	Seçilen ürünün sepette olduğunu doğrula
        WebElement sepettekiUrun = driver.findElement(By.xpath("(//*[text()='Yeni Başlayanlar için Java (Eğitim Videolu) '])"));
        Assert.assertTrue(sepettekiUrun.isDisplayed());

//7	Sepetteki ürünü silmek için "x" butonuna tıkla.
        driver.findElement(By.cssSelector("[title='Kaldır']")).click();

//  8 Sepetteki ürünün silindiğini doğrula.
        WebElement urunSilindi = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(urunSilindi.isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
    public void bekle(int sn){
        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
