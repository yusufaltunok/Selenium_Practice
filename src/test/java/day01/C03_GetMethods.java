package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GetMethods {
    public static void main(String[] args) {


        /*
        Yeni bir package olusturalim : day01
        Yeni bir class olusturalim : C03_GetMethods
        Amazon sayfasina gidelim. https://www.amazon.com/
        Sayfa basligini(title) yazdirin
        Sayfa basliginin “Amazon” icerdigini test edin
        Sayfa adresini(url) yazdirin
        Sayfa url’inin “amazon” icerdigini test edin.
        Sayfa handle degerini yazdirin
        Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        Sayfayi kapatin.

*/

        System.setProperty("web driver.chrome.driver", "src/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com/");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String actualTitle = driver.getTitle();
        String arananKelime = "Amazon";
        if (actualTitle.contains(arananKelime)) {
            System.out.println("Test PASSED " );
        }else  System.out.println("Test FAILED --> "+ actualTitle );

        System.out.println("Amazon Url= " + driver.getCurrentUrl());

        String actualUrl = driver.getCurrentUrl();
        String arananUrl = "amazon";
        if (actualUrl.contains(arananUrl)) {
            System.out.println("Test PASSED " );
        }else  System.out.println("Test FAILED --> "+ actualUrl );

        System.out.println("getWindowHandle() = " + driver.getWindowHandle());

        if (driver.getPageSource().contains("Gateway")){
            System.out.println("Test PASSED " );
        }else  System.out.println("Test FAILED " );

        driver.close();


    }
}
