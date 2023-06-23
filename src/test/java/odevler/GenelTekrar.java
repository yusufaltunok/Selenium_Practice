package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class GenelTekrar  {



        //    Test01
        //1- amazon gidin
        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        //3. dropdown menude 40 eleman olduğunu doğrulayın
        //    Test02
        //1. dropdown menuden elektronik bölümü seçin
        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        //4. ikinci ürüne relative locater kullanarak tıklayin
        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        //    Test03
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        //2. dropdown’dan bebek bölümüne secin
        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4. sonuç yazsının puset içerdiğini test edin
        //5- üçüncü ürüne relative locater kullanarak tıklayin
        //6- title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        //    Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    static String iphoneTitle;
    static String iphoneFiyat;
    static String iphoneFiyat2;
    static String iphoneGercekFiyat;


    static String bebekTitle;
    static String bebekFiyat;
    static String bebekFiyat2;
    static String bebekGercekFiyat;


    @Test
    public void test01() {
        driver.get("https://amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        List<WebElement> menu = select.getOptions();
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i).getText());

        }
        //dropdown menude 40 eleman olmadığını doğrulayın.
        Assert.assertNotEquals(40, menu.size());

    }

    @Test
    public void test02() throws InterruptedException {
        //dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        Thread.sleep(3000);
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        String sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        //1-24 of over 6,000 results for "iphone"
        String[] arr = sonucYazisi.split(" ");
        System.out.println("iphone Sonuc Sayisi = " + arr[3]);
        //Sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("div")).toRightOf(birinciUrun));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        iphoneFiyat = driver.findElement(By.xpath("(//*[@class='a-price-whole'])[7]")).getText();
        iphoneFiyat2 = driver.findElement(By.xpath("(//*[@class='a-price-fraction'])[7]")).getText();
        iphoneGercekFiyat = iphoneFiyat + "." + iphoneFiyat2;
        iphoneTitle = driver.findElement(By.xpath("(//h1)[1]")).getText();
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();
        System.out.println("iphone Gercek Fiyat ==> " + iphoneGercekFiyat);
        System.out.println("iphone Title ==> " + iphoneTitle);


    }

    @Test
    public void test03() throws InterruptedException {
        //driver.get("https://amazon.com");
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        //dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");
        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("bebek puset", Keys.ENTER);

        String sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        //1-16 of 61 results for "bebek puset"
        String[] arr = sonucYazisi.split(" ");
        System.out.println("Bebek Puset Sonuc Sayisi = " + arr[2]);
        //sonuç yazısının puset içerdiğini test edin
        Assert.assertTrue(sonucYazisi.contains("puset"));
        //ILK ürüne relative locater kullanarak tıklayin
        WebElement ikinci = driver.findElement(By.xpath("(//*[@class='s-image'])[2]"));
        driver.findElement(with(By.tagName("img")).above(ikinci)).click();
        //title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        bebekFiyat = driver.findElement(By.xpath("(//*[@class='a-price-whole'])[1]")).getText();
        bebekFiyat2 = driver.findElement(By.xpath("(//*[@class='a-price-fraction'])[1]")).getText();
        bebekGercekFiyat = bebekFiyat + "." + bebekFiyat2;
        bebekTitle = driver.findElement(By.xpath("(//h1)[1]")).getText();
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();
        System.out.println("Bebek Puset Fiyatı = " + bebekGercekFiyat);
        System.out.println("Bebek Puset title = " + bebekTitle);

    }

    @Test
    public void test04() throws InterruptedException {
        //sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        //önce sepetim'e tıklıyoruz ki sepetteki ürünleri görebilelim.
        driver.findElement(By.xpath("(//*[@class='nav-line-2'])[3]")).click();
        driver.manage().window().maximize();
        Thread.sleep(4000);
        String sepettekiBebekPusetIsim = driver.findElement(By.xpath("(//*[@class='a-truncate-cut'])[1]")).getText().replace("...", "");
        String sepettekiUrunBebekPusetFiyat = driver.findElement(By.xpath("(//*[@class='a-spacing-mini'])[2]")).getText();
        sepettekiUrunBebekPusetFiyat = sepettekiUrunBebekPusetFiyat.replace("$", "");
        System.out.println("sepetteki Bebek Puset Isim = " + sepettekiBebekPusetIsim);
        System.out.println("sepetteki Bebek Puset Fiyat" + sepettekiUrunBebekPusetFiyat);

        String sepettekiIphoneIsim = driver.findElement(By.xpath("(//*[@class='a-truncate-cut'])[2]")).getText();
        String sepettekiIphoneFiyat = driver.findElement(By.xpath("(//*[@class='a-spacing-mini'])[4]")).getText();
        sepettekiIphoneFiyat = sepettekiIphoneFiyat.replace("$", "");
        System.out.println("sepetteki Iphone Isim = " + sepettekiIphoneIsim);
        System.out.println("sepetteki Iphone Fiyat = " + sepettekiIphoneFiyat);

        Assert.assertEquals(sepettekiIphoneFiyat, iphoneGercekFiyat);
        Assert.assertEquals(sepettekiUrunBebekPusetFiyat, bebekGercekFiyat);

        System.out.println("iphone nin adını veriyor musun? " + iphoneTitle);
        System.out.println("bebekTitle adını veriyor musun? " + bebekTitle);
        Assert.assertEquals(sepettekiIphoneIsim, iphoneTitle);
        Assert.assertEquals(sepettekiBebekPusetIsim, bebekTitle);


    }
}