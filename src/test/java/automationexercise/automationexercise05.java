package automationexercise;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class automationexercise05 {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);
//        4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
//        5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
//        6. Adı ve kayıtlı e-posta adresini girin
//        7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@name='name']")).
                                   sendKeys("yusufaltunok", Keys.TAB,"yusuf1325@gmail.com",Keys.ENTER);
//        8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());


    }
}





