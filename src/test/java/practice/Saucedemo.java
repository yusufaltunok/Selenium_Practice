package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Saucedemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //"https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //Username kutusuna "standard_user" yazdirin
        //Password kutusuna "secret_sauce" yazdirin
        //Login tusuna basin
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user", Keys.TAB, "secret_sauce", Keys.TAB, Keys.ENTER);
        Thread.sleep(2000);


        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urunADi = driver.findElement(By.id("item_4_title_link"));
        System.out.println("Ürün adı = " + urunADi.getText());
        Thread.sleep(2000);

        WebElement uruneGit = driver.findElement(By.id("item_4_title_link"));
        uruneGit.click();
        //Add to Cart butonuna basin
        WebElement kartEkle = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        kartEkle.click();

        Thread.sleep(2000);

        //Alisveris sepetine tiklayin
        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();
        //Sectiginiz urunun basarili olarak sepete eklendigini control  edin
        WebElement alisverisKontrol = driver.findElement(By.xpath("//div[@class='cart_quantity']"));
        String actualKonrol = alisverisKontrol.getText();
        String expectedKontrol = "1";
        if (actualKonrol.contains(expectedKontrol)) {
            System.out.println("1 Tane ürününüz sepete eklenmiştir");
        } else System.out.println("Sepette ürün yok");
        Thread.sleep(2000);

        //Sayfayi kapatin
        driver.close();

    }
}