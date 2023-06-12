package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class automationexercise09 {
//    1. Tarayıcıyı başlatın
//    2. 'http://automationexercise.com' URL'sine gidin
//    3. Ana sayfanın başarıyla göründüğünü doğrulayın
//    4. 'Ürünler' düğmesine tıklayın
//    5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
//    6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
//    7. "ARALAN ÜRÜNLER"in görünür olduğunu doğrulayın
//    8. Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
//    2.'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
//    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
//    4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Products']")).click();


//    5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement tumUrunler = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(tumUrunler.getText().contains("All Products"));


//    6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("jeans", Keys.TAB, Keys.ENTER);
//    7. "ARANAN ÜRÜNLER"in görünür olduğunu doğrulayın
        WebElement arananUrunler = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(arananUrunler.isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }



}
