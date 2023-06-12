package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Nutella {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.findElement(By.id("APjFqb")).sendKeys("Nutella",Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.cssSelector("div[id='result-stats']"));
        System.out.println("sonucYazisi = " + sonucYazisi.getText());
        String [] result = sonucYazisi.getText().split(" ");
        String sonuc = result[1];
        System.out.println("sonuc = " + sonuc);

        String actualSayfaSayisi = sonucYazisi.getText();
        String expectedSayfaSayisi ="";

        if (actualSayfaSayisi.contains(expectedSayfaSayisi)){
            System.out.println("10m den fazla");
        }else System.out.println("10m den az");


//        Integer sayi= Integer.valueOf(sonuc);
//
//        System.out.println("sayi = " + sayi);

/*

 */



    }

}
