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

import java.time.Duration;

public class automationexercise04 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    /*
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' URL'sine gidin
    3. Ana sayfanın başarıyla göründüğünü doğrulayın
    4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
    6. Doğru e-posta adresini ve şifreyi girin
    7. 'Giriş' düğmesine tıklayın
    8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    9. 'Çıkış' düğmesini tıklayın
    10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
     */


    @Test
    public void test() {
        //'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
        //'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //"Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement girisYapYazisi = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(girisYapYazisi.isEnabled());
        // Doğru e-posta adresini ve şifreyi girin
        //'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("yusuf66@gmail.com", Keys.TAB,"123456",Keys.ENTER);
        //  8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement loggedInYazisi =  driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        System.out.println("loggedInYazisi = " + loggedInYazisi.getText());
        Assert.assertTrue(loggedInYazisi.isDisplayed());
        //'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
        //Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
