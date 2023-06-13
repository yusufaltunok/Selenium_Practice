package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowHandle extends TestBase {
//    Yeni bir class olusturun: WindowHandle
//    Amazon anasayfa adresine gidin.
//    Sayfa’nin window handle degerini String bir degiskene atayin
//    Sayfa title’nin “Amazon” icerdigini test edin
//    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
//    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
//    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
//    Sayfa title’nin “Walmart” icerdigini test edin
//    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin


    @Test
    public void WindowHandle() {
//    Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

//    Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();

//    Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));

//    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

//    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitleTechpro = driver.getTitle();
        Assert.assertFalse(actualTitleTechpro.contains("TECHPROEDUCATION"));

//    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

//    Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitleWalmart = driver.getTitle();
        Assert.assertTrue(actualTitleWalmart.contains("Walmart"));

//    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        String actualUrlAmazon = driver.getCurrentUrl();
        String expectedUrlAmazon = "https://www.amazon.com/";
        Assert.assertEquals(actualUrlAmazon,expectedUrlAmazon);







    }
}
