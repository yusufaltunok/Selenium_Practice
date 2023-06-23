package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class automationexercise06 extends TestBase {
    @Test
    public void test() {

//        1. Tarayıcıyı başlatın
//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

//        4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("(//a)[9]")).click();

//        5. "İLETİŞİME GEÇİN"in görünür olduğunu doğrulayın
        WebElement iletisimYazisi = driver.findElement(By.xpath("(//h2)[2]"));
        Assert.assertTrue(iletisimYazisi.isDisplayed());

//        6. Adı, e-postayı, konuyu ve mesajı girin
        WebElement form = driver.findElement(By.xpath("(//input)[2]"));
        form.sendKeys("yusuf" + Keys.TAB + "yusuf@gmail.com" + Keys.TAB +
                "Exercises" + Keys.TAB, "YusufAltunok Selenium çalışması");
        bekle(2);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

//        7. Dosya yükleyin
        WebElement dosyaSec = driver.findElement(By.name("upload_file"));
        String dosyaYolu = "C:\\Users\\EXCALIBUR\\Desktop\\Manual Test Interview Questions.pdf";
        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);

//        8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        //  driver.switchTo().alert().accept();
        bekle(2);

//        9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();
        actions.sendKeys(Keys.PAGE_UP).perform();
        bekle(2);

//        10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
        WebElement basariMsg = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        Assert.assertTrue(basariMsg.isDisplayed());

//        11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın
        driver.findElement(By.xpath("(//*[@class='btn btn-success'])[1]")).click();

        WebElement iframe = driver.findElement(By.cssSelector("[id=aswift_1]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();


       driver.switchTo().alert().dismiss();


//        driver.switchTo().frame(1);
//        driver.findElement(By.cssSelector("[id=dismiss-button]")).click();

        actualUrl = driver.getCurrentUrl();
        expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);


    }


}
