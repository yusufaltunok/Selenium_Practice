package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Alert extends TestBase {

    @Test
    public void rest01() {
//        -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

//        -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();


//        -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        driver.switchTo().alert().accept();

//        -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

//        -Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

//        -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();

//        -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("yusuf");
        bekle(2);
        driver.switchTo().alert().accept();

//        -Çıkan mesajı konsola yazdırınız
        String mesaj = driver.findElement(By.cssSelector("[id=demo1]")).getText();
        System.out.println(mesaj);

//        -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals(mesaj,"Hello yusuf How are you today");
    }
}
