package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        1-C01_TekrarTesti isimli bir class olusturun

//        2- https://www.amazon.com/ adresine gidin
        driver.navigate().to("https://www.amazon.com/");

//        3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

//        4.- Sayfayi “refresh” yapin
        driver.navigate().refresh();

//        5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Spend less";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED!");
        }else System.out.println("Test FAILED");

//        6. Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@data-csa-c-slot-id='nav_cs_3']")).click();

//        7. Birthday butonuna basin
        driver.findElement(By.xpath("(//*[text()='Birthday'])[1]")).click();

//        8. Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();

//        9. Gift card details’den 25 $’i secin

        driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]")).click();
//
//        10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucret = driver.findElement(By.xpath("//*[@id='gc-live-preview-amount']"));
        if (ucret.getText().equals("$25.00")) {
            System.out.println("Test PASSED!");
        }else System.out.println("Test FAILED");

//        10-Sayfayi kapatin
        driver.close();
    }
}
