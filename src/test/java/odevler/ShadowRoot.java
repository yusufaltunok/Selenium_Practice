package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ShadowRoot extends TestBase {
    @Test
    public void test01() {
        // https://fiddle.luigi-project.io/#/home/wc1 sitesine git
        driver.get("https://fiddle.luigi-project.io/#/home/wc1");

        // shadowRoot içine gir
        SearchContext shadowRoot = driver.findElement(By.tagName("luigi-wc-2f77632f6c6973742e6a73")).getShadowRoot();

        //Kutunun içine yusuf yaz
        shadowRoot.findElement(By.className("add-new-list-item-input")).sendKeys("yusuf");

    }
}
