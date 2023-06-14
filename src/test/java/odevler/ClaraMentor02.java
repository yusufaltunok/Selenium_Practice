package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class ClaraMentor02 extends TestBase {
    //  ...Exercise2...
//  1-driver olusturalim
//  2-java class'imiza chromedriver.exe'yi tanitalim
//  3-driver'in tum ekrani kaplamasini saglayalim
//  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
//    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.

    @Test
    public void test01() {

//  5-"sahibinden.com" adresine gidelim
        driver.get("https://www.sahibinden.com");
        String sahibindenHandle = driver.getWindowHandle();

//  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String sahibindenTitle = driver.getTitle();
        String sahibindenUrl = driver.getCurrentUrl();

//  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(sahibindenTitle.contains("Oto"));
        Assert.assertFalse(sahibindenUrl.contains("Oto"));

//  8-Ardindan "gittigidiyor.com" adresine gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.hepsiburada.com");
        String hepsiburadaHandle = driver.getWindowHandle();

//  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini  kontrol edelim
        String hepsiburadaTitle = driver.getTitle();
        Assert.assertTrue(hepsiburadaTitle.contains("Sitesi"));

//  10-Bi onceki web sayfamiza geri donelim
        driver.switchTo().window(sahibindenHandle);

//  11-sayfayi yenileyelim
        driver.navigate().refresh();

//  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.switchTo().window(hepsiburadaHandle);
        driver.navigate().forward();
        driver.close();

//  13-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.switchTo().window(sahibindenHandle);
        driver.close();










    }
}



