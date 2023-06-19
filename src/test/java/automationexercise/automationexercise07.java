package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class automationexercise07 extends TestBase {

    @Test
    public void test01() {
//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

//        4. 'Test Durumları' düğmesine tıklayın
        driver.findElement(By.xpath("(//a)[6]")).click();

//        5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        //driver.findElement(By.cssSelector("[class=ns-jp5fz-e-16]")).click();
        WebElement testCaseDogrula = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(testCaseDogrula.isDisplayed());






    }
}
