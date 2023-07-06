package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class automationexercise11 extends TestBase {
    @Test
    public void test01() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertEquals("Automation Exercise", driver.getTitle());

        //4. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//a)[4]")).click();

        //5. Altbilgiye doğru aşağı kaydırın

        //6. 'ABONELİK' metnini doğrulayın
        String actualAbonelik = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals("SUBSCRIPTION",actualAbonelik);

        //7. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.id("susbscribe_email")).sendKeys("yusuf@gmail.com", Keys.ENTER);
        bekle(5);

        //8. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        driver.findElement(By.xpath("//*[@class='alert-success alert']")).isDisplayed();

    }

    public static class automationexercise13 extends TestBase {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        //4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın
        //5. Ürün detayının açıldığını doğrulayın
        //6. Miktarı 4'e yükseltin
        //7. 'Sepete ekle' düğmesini tıklayın
        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        //9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
    }
}
