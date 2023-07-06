package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class automationexercise10 extends TestBase {
    @Test
    public void test01() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertEquals("Automation Exercise", driver.getTitle());

        // Sayfanın alt tarafındaki Shadow root reklamı kapat
//        SearchContext searchContext = driver.findElement(By.xpath("//*[@id='grippy-host']")).getShadowRoot();
//        searchContext.findElement(By.xpath("(//*[@class='down'])[1]")).click();

        //4. Altbilgiye doğru aşağı kaydırın
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,8200).perform();

        //5. 'ABONELİK' metnini doğrulayın
        String actualAbonelik = driver.findElement(By.xpath("(//h2)[82]")).getText();
        Assert.assertEquals("SUBSCRIPTION",actualAbonelik);

        //6. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.id("susbscribe_email")).sendKeys("yusuf@gmail.com", Keys.ENTER);
        bekle(10);

        //7. Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür
        driver.findElement(By.xpath("//*[@class='alert-success alert']")).isDisplayed();






    }
}
