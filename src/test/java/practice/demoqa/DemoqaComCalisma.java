package practice.demoqa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoqaComCalisma {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        https://demoqa.com/ adresıne gıt
        driver.get("https://demoqa.com/");
    }

    @Test
    public void test01() throws InterruptedException {
        // JavascriptExecutor örneği al
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Sayfayı 500 piksel aşağı kaydır
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);
//        Elemets sekmesını locate et ve tıkla
        js.executeScript("window.scrollBy(0, 300)");
        driver.findElement(By.xpath("(//h5)[1]")).click();
//        Elements altında WEbTables ı locate edıp tıkla
        driver.findElement(By.xpath("(//*[@class='text'])[4]")).click();
//        cıkan ekranda Add butonu tıkla ve regıstratıon formu nu doldur
        driver.findElement(By.id("addNewRecordButton")).click();
//        fırst:name=username1
//        lastname=lastname1
//        emaıl =abc @ gmaıl.com
//                age=30
//        salary=10000
//        department =ad bılgılerını doldur ve submıt et
        driver.findElement(By.xpath("//*[@id='firstName']")).
                sendKeys("username1", Keys.TAB, "lastname1", Keys.TAB, "abc@gmail.com", Keys.TAB, "30", Keys.TAB, "10000", Keys.TAB, "It", Keys.ENTER);
//        eklendıgını  maıl yoluyla dogrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='abc@gmail.com']")).isDisplayed());

//        edıt ı locate et maasını 15000 olarak guncelle
//        submıt et

        driver.findElement(By.id("edit-record-4")).click();
        WebElement salary = driver.findElement(By.xpath("//*[@id='salary']"));
        salary.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        salary.sendKeys("15000", Keys.ENTER);
//        15000 oldugunu dogrula
        WebElement actualSalary = driver.findElement(By.xpath("(//*[@class='rt-td'])[26]"));
        System.out.println(actualSalary.getText());

        Assert.assertEquals(actualSalary.getText(), "15000");

//        sılme tusunu locate et ve fırstname ı Alden olanı sıl
        driver.findElement(By.id("delete-record-2")).click();

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
