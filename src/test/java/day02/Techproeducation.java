package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Techproeducation {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");


    //Çıkan reklamı locate edip kapatalım
       driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

    //Arama bölümünde qa aratalım
        driver.findElement(By.id("elementor-search-form-9f26725")).sendKeys("qa", Keys.ENTER);

    //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String arananKelime = "qa";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> "+ actualTitle);

    //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement career = driver.findElement(By.xpath("(//*[@class='elementor-post__thumbnail__link'])[1]"));
        Boolean gorunurMu = career.isDisplayed();
        Boolean erisilirMi = career.isEnabled();
        System.out.println(gorunurMu);
        System.out.println(erisilirMi);


        //Carrer Opportunities In QA linkine tıklayalım
        career.click();

    //Başlığın Opportunities içerdiğini test edelim
        String baslik = driver.getTitle();
        System.out.println(baslik);
        String beklenenBaslik = "Opportunities";
        if (baslik.contains(beklenenBaslik)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> "+ baslik);


    //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.navigate().back();
        driver.navigate().back();

        String url = driver.getCurrentUrl();
        String currentUrl = "https://techproeducation.com/";
        if (url.contains(currentUrl)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> "+ url);

        driver.close();




    }
}
