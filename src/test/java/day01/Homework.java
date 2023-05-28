package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {
    public static void main(String[] args) {

         /*
        Yeni bir class olusturalim (Homework)
        ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        yazdirin.
        https://www.walmart.com/ sayfasina gidin.
        Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        Tekrar “facebook” sayfasina donun
        Sayfayi yenileyin
        Sayfayi tam sayfa (maximize) yapin  9.Browser’i kapatin
         */
        System.setProperty("web driver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
        if (title.equals("facebook")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -->"+title);

        String url = driver.getCurrentUrl();
        if (url.contains("facebook")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED "+ url);

        driver.get("https://www.walmart.com/");
        String title2 = driver.getTitle();
        if (title2.contains("Walmart.com")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -->"+title2);

        driver.navigate().back();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.close();



    }
}
