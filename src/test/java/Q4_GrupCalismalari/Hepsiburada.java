package Q4_GrupCalismalari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Hepsiburada extends TestBase {
    @Test
    public void test01() {
//hepsiburada.com'a git
        driver.get("https://www.hepsiburada.com");
/*
//mouse ile giriş yap' ın üstüne gidip aşağıda açılan menüden giriş yap butonuna tıkla.
        WebElement girisYap = driver.findElement(By.cssSelector("[data-test-id=account]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(girisYap).perform();
        bekle(2);

        driver.findElement(By.cssSelector("[id=login]")).click();

//e posta = yusufaltunok@hotmail.com yazıp Giriş Yap'a tıkla.
        driver.findElement(By.xpath("(//*[@id='txtUserName'])[1]")).sendKeys("yusufaltunok@hotmail.com", Keys.ENTER);

//Şifre = Yusuf1977 ENTER'a bas.
       WebElement password = driver.findElement(By.xpath("(//*[@id='txtPassword'])[1]"));
        password.sendKeys("Yusuf1977");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        password.sendKeys(Keys.TAB,Keys.ENTER);

*/
        bekle(2);
        WebElement cerezKabulEt = driver.findElement(By.cssSelector("[id='onetrust-accept-btn-handler']"));
        cerezKabulEt.click();

//Ekrandaki Spor,Outdoor'un üzerine gelip aşağıda açılan Kamp Kampçılık Malzemelerinin altındaki Kamp Sandalyesine tıkla
        Actions actions = new Actions(driver);
        WebElement spor = driver.findElement(By.xpath("(//*[@class='sf-MenuItems-UHHCg2qrE5_YBqDV_7AC'])[6]"));
        actions.moveToElement(spor).perform();
        bekle(2);
        driver.findElement(By.cssSelector("[class='sf-ChildMenuItems-OIXGN6gTcuAXz_dkh8Yv item-3130']")).click();


//Sağ yukarıdaki Sıralama butonundan Çok Satanları tıkla.
        driver.findElement(By.className("sorting-area")).click();
        driver.findElement(By.xpath("(//*[@class='horizontalSortingBar-PkoDOH7UsCwBrQaQx9bn'])[3]")).click();

//Açılan sandalyelerden soldan 2 üstten 2. ye relative locater kullanarak tıkla.
        WebElement ikinciUrun = driver.findElement(By.xpath("(//h3)[2]"));
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        WebElement sandalye = driver.findElement(with(By.tagName("h3")).below(ikinciUrun));//Tıklayınca Yeni sekme açılacak. Ürün başlığı ile fiyatını bir variable'a ata.
        sandalye.click();

//Tıklayınca Yeni sekme açılacak. Ürün başlığı ile fiyatını bir variable'a ata.
        switchToWindow(1);
        String urunBasligi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(urunBasligi);
        String fiyat = driver.findElement(By.cssSelector("[id='offering-price']")).getText();
        System.out.println(fiyat);

//Sepete ekle.
        driver.findElement(By.cssSelector("[id='addToCart']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")));

//Ürün sepetinizde yazısının çıktığını doğrula.
        WebElement urunSepetinizde = driver.findElement(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']"));
        Assert.assertEquals("Ürün sepetinizde", urunSepetinizde.getText());

//Alışverişe devam et'e tıkla.
        driver.findElement(By.cssSelector("[kind=\"secondary\"]")).click();

//Marka'dan 2. sıradakini seç, seçildiğini doğrula
        driver.findElement(By.xpath("(//*[@type=\"checkbox\"])[11]")).click();
        bekle(2);
        driver.navigate().refresh();
        WebElement marka = driver.findElement(By.cssSelector("[class=\"appliedVerticalFilter-pSOYt8wpwv9fUK7bNUjk\"]"));
        Assert.assertTrue(marka.isDisplayed());

//     Fiyat aralığı 200 -500 gir, arama butonuna tıkla.
        driver.findElement(By.xpath("//*[text()='ürün listeleniyor']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        driver.navigate().refresh();
        driver.findElement(By.cssSelector("[placeholder='En az']")).
                sendKeys("200", Keys.TAB, "500", Keys.TAB, Keys.ENTER);
        driver.navigate().refresh();

        Assert.assertTrue(
                driver.findElement(By.xpath("(//*[@class='appliedVerticalFilter-rxdhhFDFaJiRVL0RqUW_'])[1]")).isDisplayed());

//Sıralama'dan yüksek puanlıları seçip son çıkan ürüne tıkla.
        driver.findElement(By.className("sorting-area")).click();
        driver.findElement(By.xpath("(//*[@class='horizontalSortingBar-PkoDOH7UsCwBrQaQx9bn'])[6]")).click();
        driver.findElement(By.xpath("(//h3)[1]")).click();

//Sepete ekle.
        switchToWindow(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("[id=addToCart]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")));

//Ürün sepetinizde yazısının çıktığını doğrula.
        WebElement urunSepetinizde1 = driver.findElement(By.cssSelector("[class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']"));
        Assert.assertEquals("Ürün sepetinizde", urunSepetinizde1.getText());

//Sepete Git'e tıkla.
        driver.findElement(By.xpath("(//*[@type='button'])[6]")).click();

//Alışverişi tamamla butonuna tıkla.
        driver.findElement(By.id("continue_step_btn")).click();

    }
}
