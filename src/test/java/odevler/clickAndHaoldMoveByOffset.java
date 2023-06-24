package odevler;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class clickAndHaoldMoveByOffset extends TestBase {
    @Test
    public void test01() throws IOException {
//-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
//-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);

        WebElement yesil = driver.findElement(By.xpath("//*[@id='green']"));
        actions.clickAndHold(yesil).
                moveByOffset(-160, 0).
                perform();
        
        bekle(2);
        actions.moveByOffset(320, 0).release().perform();

//-Sarı olduğunu test edelim

       WebElement kutu = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 60);']"));
       String color = kutu.getAttribute("style");
       Assert.assertEquals("background-color: rgb(255, 255, 60);",color);


        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        FileUtils.copyFile(kutu.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

      
     
    }

}
