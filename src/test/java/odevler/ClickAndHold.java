package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ClickAndHold extends TestBase {
    @Test
    public void test01() {

//    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//    2- Hover over  Me First" kutusunun ustune gelin
        WebElement howerOwer = driver.findElement(By.className("dropbtn"));
        Actions actions = new Actions(driver);
        actions.moveToElement(howerOwer).perform();

//    3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

//    4- Popup mesajini yazdirin
        driver.switchTo().alert().getText();

//    5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

//    6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.cssSelector("[id=click-box]"));
        actions.clickAndHold(clickAndHold).perform();

//    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

//    8- "Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClick = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();
        String actualClass = doubleClick.getAttribute("class");
        String expectedClass = "div-double-click double";
        Assert.assertEquals(expectedClass, actualClass);

//        String renk = doubleClickelement.getCssValue("background-color");
//        System.out.println(renk);
//        Assert.assertTrue(renk.equals("rgba(147, 203, 90, 1)"));


    }
}
