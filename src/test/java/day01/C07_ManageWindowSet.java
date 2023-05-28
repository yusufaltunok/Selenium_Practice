package day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ManageWindowSet {
    public static void main(String[] args) {

          /*
        Yeni bir Class olusturalim. C07_ManageWindowSet
        Amazon soyfasina gidelim. https://www.amazon.com/
        Sayfanin konumunu ve boyutlarini yazdirin
        Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
         */

        System.setProperty("web driver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com/");
        System.out.println("Sayfa Konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfa Boyutu = " + driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(600,600));
        driver.manage().window().setSize(new Dimension(1000,700));

//        System.out.println("Sayfa Yeni Konumu = " + driver.manage().window().getPosition());
//        System.out.println("Sayfa Yeni  Boyutu = " + driver.manage().window().getSize());

        Point actualPosition = driver.manage().window().getPosition();
        Dimension actualSize = driver.manage().window().getSize();

        if (actualPosition.equals(new Point(600,600))){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        if (actualSize.equals(new Dimension(1000,700))){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");



    }
}
