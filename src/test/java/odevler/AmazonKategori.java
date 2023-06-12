package odevler;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AmazonKategori {
    /*
      ●https://www.amazon.com/ adresine gidin.
  -Test 1
  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
  -Test 2
  1.Kategori menusunden Books secenegini secin
  2.Arama kutusuna Java yazin ve aratin
  3.Bulunan sonuc sayisini yazdirin
  4.Sonucun Java kelimesini icerdigini test edin
   */
    WebDriver driver;
    Select select;
    WebElement kategori;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @Test
    public void test01() {
//    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        kategori = driver.findElement(By.xpath("(//select)"));
        select = new Select(kategori);
        select.getOptions().size();
        Assert.assertNotEquals(45, select.getOptions().size());
    }

    @Test
    public void test02() {
//   1.Kategori menusunden Books secenegini secin
        kategori = driver.findElement(By.xpath("(//select)"));
        select = new Select(kategori);
        select.selectByIndex(5);

//   2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.cssSelector("[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

//   3.Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String[] sonuc = sonucSayisi.getText().split(" ");
        System.out.println(sonuc[3]);

//   4.Sonucun Java kelimesini icerdigini test edin
        String sonucYazisi = sonucSayisi.getText();
        Assert.assertTrue(sonucYazisi.contains("Java"));
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
