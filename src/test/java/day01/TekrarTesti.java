package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TekrarTesti {
    public static void main(String[] args) {

           /*
        Yeni bir class olusturun (TekrarTesti)
        Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        Youtube sayfasina geri donun
        Sayfayi yenileyin
        Amazon sayfasina donun
        Sayfayi tamsayfa yapin
        Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
        Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın

        Sayfayi kapatin

         */

        System.setProperty("web driver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //        Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify),
        //        eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("youtube")) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -->"+ actualTitle);

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("youtube")) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -->"+ currentUrl);

        driver.get("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().fullscreen();
        String amazonTitle = driver.getTitle();
        if (amazonTitle.contains("Amazon")) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -->"+ amazonTitle);
        String amazonUrl = driver.getCurrentUrl();
        if (amazonUrl.equals("https://www.amazon.com/")) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -->"+ amazonUrl);
        driver.close();






    }
}
