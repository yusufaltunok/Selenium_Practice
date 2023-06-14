package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Emoji extends TestBase {
    @Test
    public void test01() {

    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

    // ikinci emojiye tıklayın
        WebElement emojiFrame = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(emojiFrame);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


    // İkinci emoji öğelerini yazdırınız
        System.out.println(driver.findElement(By.xpath("//*[@class='mdl-tabs__panel is-active']")).getText());

    // Parent iframe e geri donun
        driver.switchTo().defaultContent();

    // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.cssSelector("[id=text]")).sendKeys("QA", Keys.TAB,"yusuf",Keys.TAB,"mehtap",
                Keys.TAB,"bahadır",Keys.TAB,"sevde",Keys.TAB,"murat", Keys.TAB,"QA", Keys.TAB,"yusuf",Keys.TAB,"mehtap",
                Keys.TAB,"bahadır",Keys.TAB,"it",Keys.TAB,Keys.ENTER);
    // Apply button a basiniz


    }
}
