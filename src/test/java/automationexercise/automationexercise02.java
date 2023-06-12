package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class automationexercise02 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";

        if(actualURL.equals(expectedURL)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED " +actualURL );
        }
//        4. 'Ürünler' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
//      reklamı kapat
//       driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
//       driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();
//        driver.findElement(By.xpath("//*[@id='dismiss-button']"));

        // JavascriptExecutor örneği al
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Sayfayı 500 piksel aşağı kaydır
        js.executeScript("window.scrollBy(0, 500)");


//        5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        //driver.findElement(By.xpath("((//*[@class='btn btn-default add-to-cart'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();

//        6. 'Alışverişe Devam Et' düğmesini tıklayın
       // driver.findElement(By.linkText("Continue Shopping")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        driver.navigate().back();

//        7. İkinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//*[@class='nav nav-pills nav-justified'])[2]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-default cart']")).click();

//       8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();


//        9. Her iki ürünün de Sepete eklendiğini doğrulayın
//        10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın


    }
}
