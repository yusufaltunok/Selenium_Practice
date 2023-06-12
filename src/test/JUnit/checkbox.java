package practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class checkbox {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    /*
  a.Verilen web sayfasına gidin.
  https://the-internet.herokuapp.com/checkboxes
  b.Checkbox1 ve checkbox2 elementlerini locate edin.
  c.Checkbox1 seçili değilse onay kutusunu tıklayın
  d.Checkbox2 seçili değilse onay kutusunu tıklayın
   */
    @Test
    public void test1() {

        driver.findElement(By.xpath("((//div//input)[1]")).click();

        WebElement checkbox2 = driver.findElement(By.cssSelector("input[checked]"));
        if (!checkbox2.isSelected()) {
            driver.findElement(By.xpath("((//div//input)[2]")).click();
        }
    }
    @Test
    public void test2() {
        driver.get("https://facebook.com");
        driver.findElement(By.linkText("Yeni hesap oluştur")).click();
        driver.findElements(By.xpath("(//input[@type='radio'])[1] | (//input[@type='radio'])[2] | (//input[@type='radio'])[3]"));

       WebElement erkek = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
       if (!erkek.isSelected()){
          // driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
           erkek.click();
       }

    }
            /*
            -https://www.facebook.com adresine gidin
-Cookies’i kabul edin
-“Create an Account” button’una basin
-“radio buttons” elementlerini locate edin
-Secili degilse cinsiyet butonundan size uygun olani secin

             */
}
