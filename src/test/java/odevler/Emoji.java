package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test02() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();

        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//div"));
        for (WebElement w:emojiler) {
            System.out.println(w.getText());
        }

        // Parent iframe e geri donun
        driver.switchTo().defaultContent();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> veriler = new ArrayList<>(Arrays.asList(
                "Erol","Evren","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }
        driver.findElement(By.xpath("//*[text()='Apply']")).click();
    }
}
