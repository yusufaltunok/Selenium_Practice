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
        SearchContext shadowRoot = driver.findElement(By.tagName("cmm-cookie-banner")).getShadowRoot();
        shadowRoot.findElement(By.className("button")).click();

        // alternatif çozum

//        SearchContext searchContext = driver.findElement(By.xpath("//*[@class='hydrated']")).getShadowRoot();
//        searchContext.findElement(By.className("button")).click();
    }
        @Test
        public void test02() {

            driver.get("https://www.mercedes-benz.com.tr/");
            WebElement element = driver.findElement(By.tagName("cmm-cookie-banner"));
            bekle(1);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return arguments[0].shadowRoot",element);
            SearchContext shadowRoot = element.getShadowRoot();
            shadowRoot.findElement(By.cssSelector("[class='button button--accept-all wb-button hydrated']")).click();
        }









}
