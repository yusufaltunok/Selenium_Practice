package Q4_GrupCalismalari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;


public class Sahibinden extends TestBase {
    @Test
    public void test01() {
        //sahibinden.com adersine git
        driver.get("https://sahibinden.com");

        //Acılısta gelen cerezi reddet
        driver.findElement(By.cssSelector("[id='onetrust-reject-all-handler']")).click();

        //koctas videosuna tıkla
        //ilk iframe'e gecis yap
        WebElement ilkIframe = driver.findElement(By.cssSelector("[id='google_ads_iframe_/32607536/mainpage_masthead_0']"));
        driver.switchTo().frame(ilkIframe);

        WebElement ikinciIframe = driver.findElement(By.cssSelector("[class='you-video']"));
        driver.switchTo().frame(ikinciIframe);

        driver.findElement(By.xpath("//*[text()='koctas.com.tr ile her evde moda!']")).click();

        //youtubeda videoyu pause tusuna basarak durdur
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.findElement(By.cssSelector("[class='ytp-play-button ytp-button']")).click();

        //sahibinden.com sıtesine geri don
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        //Vasıta  altındakı otomobil secenegine tıkla
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        driver.findElement(By.cssSelector("[href='/kategori/otomobil']")).click();


    }

    @Test
    public void test02() {
        //sahibinden.com adersine git
        driver.get("https://sahibinden.com");

        //Acılısta gelen cerezi reddet
        driver.findElement(By.cssSelector("[id='onetrust-reject-all-handler']")).click();

        //sahibinden.com logosunun gorunur oldugunu dogrula
        WebElement logo = driver.findElement(By.cssSelector("[class=logo]"));
        Assert.assertTrue(logo.isDisplayed());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
       // actions.contextClick(driver.findElement(By.cssSelector("[href='/kategori/otomobil']")));
        driver.findElement(By.cssSelector("[href='/kategori/otomobil']")).sendKeys(Keys.CONTROL,Keys.ENTER);


        //BMW ye tıkla
        driver.findElement(By.xpath("(//h2)[8]")).click();

        //sıralama butonuna tıkla ve urunlerı en yuksek fiyata gore sırala
        driver.findElement(By.id("advancedSorting")).click();
        driver.findElement(By.xpath("//*[text()='Fiyata göre (Önce en yüksek)']")).click();

        //10. araca tıkla (class=searchResultTıtleValue)
//
        for (int i = 0; i <10 ; i++) {
            driver.findElement(By.xpath("//tr"));

        }

        //fıyatı al ve 13.900.000 TL oldugunu dogrula
//

    }
}
