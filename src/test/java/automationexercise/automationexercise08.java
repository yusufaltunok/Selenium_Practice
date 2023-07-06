package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class automationexercise08 extends TestBase {

    @Test
    public void test01() {
//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

//        4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("(//a)[3]")).click();

//        5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini


//        6. Ürün listesi görünür
        WebElement urunListe = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(urunListe.isDisplayed());


//        7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("//*[@href=\"/product_details/1\"]")).click();

//        8. Kullanıcı ürün detay sayfasına yönlendirildi
        String actualTitle = driver.getTitle();
        String expectedTitle = "https://automationexercise.com/product_details/1";
        Assert.assertEquals(actualTitle,expectedTitle);

//        9. Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın.
        WebElement urunDetay = driver.findElement(By.className("product-information"));
        Assert.assertTrue(urunDetay.isDisplayed());





    }
}
