package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeAssertion {
    /*
    1)Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri
    yapin
    => Sayfa başlığının “YouTube” oldugunu test edin
    => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void BaslikVeResimTest() {
//  Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle,expectedTitle);

//  YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement resim = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(resim.isDisplayed());
    }

    @Test
    public void SearchBoxTest() {


//  Search Box'in erisilebilir oldugunu test edin (isEnabled())
        WebElement SearchBox = driver.findElement(By.cssSelector("input[id='search']"));
        Assert.assertTrue(SearchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
//  wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "youTube";
        Assert.assertFalse(actualTitle.equals(expectedTitle));
       // Assert.assertNotEquals(actualTitle,expectedTitle);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
