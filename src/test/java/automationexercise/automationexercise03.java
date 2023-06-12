package automationexercise;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class automationexercise03 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

    }

    @Test
    public void test01() throws InterruptedException {
//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);
//        4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
//        5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());
//        6. Yanlış e-posta adresi ve şifre girin
//        7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("asd@gmail.com", Keys.TAB,"123456",Keys.ENTER);
//        8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());
        Thread.sleep(2000);
    }

    @After
    public void tearDown() throws Exception {
       driver.close();
    }
}
