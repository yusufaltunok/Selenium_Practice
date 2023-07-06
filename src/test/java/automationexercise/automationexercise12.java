package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class automationexercise12 extends TestBase {
    @Test
    public void test01() {
        Actions actions = new Actions(driver);
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertEquals("Automation Exercise", driver.getTitle());

//        WebElement iframe = driver.findElement(By.id("aswift_5"));
//        driver.switchTo().frame(iframe);
//        WebElement frame = driver.findElement(By.id("//*[@id='ad_iframe']"));
//        driver.switchTo().frame(frame);
//        driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

        //4. 'Ürünler' düğmesini tıklayın
        driver.findElement(By.xpath("(//a)[3]")).click();
        bekle(2);

        //5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement ilkUrun = driver.findElement(By.xpath("(//h2)[4]"));
        actions.moveToElement(ilkUrun).perform();
        bekle(2);
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();

        //6. 'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

        //7. İkinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        WebElement ikinciUrun = driver.findElement(By.xpath("(//h2)[6]"));
        actions.moveToElement(ikinciUrun).perform();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]")).click();

        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//u")).click();

        //9. Her iki ürünün de Sepete eklendiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='fa fa-times'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='fa fa-times'])[2]")).isDisplayed());

        //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın

    }
}
