package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Mercedes extends TestBase {
    @Test
    public void test01() {
        // https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE sayfasına git çerezleri kabul et
        driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");

        SearchContext searchContext = driver.findElement(By.xpath("//cmm-cookie-banner[@class='hydrated']")).getShadowRoot();

        WebElement cerez = searchContext.findElement(By.className("button"));
        cerez.click();


    }

}
