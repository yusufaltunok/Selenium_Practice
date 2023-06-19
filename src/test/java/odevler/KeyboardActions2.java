package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardActions2 extends TestBase {
    @Test
    public void test01() {
//        1.Bir Class olusturalim KeyboardActions2

//        2.https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//        3.video’yu gorecek kadar asagi inin
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

//        4.videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

//        5.videoyu calistirdiginizi test edin
        WebElement test = driver.findElement(By.className("ytp-timed-markers-container"));
        Assert.assertTrue(test.isDisplayed());
    }
}
