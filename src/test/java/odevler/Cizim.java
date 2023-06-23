package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Cizim extends TestBase {
    @Test
    public void test01() {

//        - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        WebElement ekran = driver.findElement(By.className("signature-pad--body"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(ekran).
//                clickAndHold()
//                .moveByOffset(25, 100)
//                .moveByOffset(100,-75 )
//                .moveByOffset(-75, 200)
//                .moveByOffset(200, 0)
//                .moveByOffset(0, -500)
//                .moveByOffset(-500, 300)
//                .moveByOffset(300, 500)
//                .release().perform();


        actions.clickAndHold(ekran)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .release()
                .perform();




//        - Çizimden sonra clear butonuna basınız
        //driver.findElement(By.xpath("//button[@class='button clear']")).click();
    }
}