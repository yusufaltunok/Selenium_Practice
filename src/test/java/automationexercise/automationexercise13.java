package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class automationexercise13 extends TestBase {
    @Test
    public void test01() {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");


        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertEquals("Automation Exercise", driver.getTitle());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın
        WebElement urunGoruntule =  driver.findElement(By.xpath("(//*[.='View Product'])[5]"));
        bekle(2);
        urunGoruntule.click();
        bekle(3);

        //5. Ürün detayının açıldığını doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

        //6. Miktarı 4'e yükseltin
        driver.findElement(By.xpath("//*[@id='quantity']")).sendKeys(Keys.DELETE,"4");

        //7. 'Sepete ekle' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();

        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//u")).click();

        //9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
        WebElement sepet = driver.findElement(By.className("disabled"));
        Assert.assertEquals("4",sepet.getText());
    }
}
