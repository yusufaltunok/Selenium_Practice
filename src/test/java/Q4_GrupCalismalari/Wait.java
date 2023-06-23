package Q4_GrupCalismalari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;


public class Wait extends TestBase {
    @Test
    public void test01() {
//      https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

//      Change Text to Seleniun Driver butonuna basalım
        driver.findElement(By.id("populate-text")).click();

//      Selenium Webdriver yazısının görünür olduğunu doğrulayalım.
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Selenium Webdriver']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(yazi));

        Assert.assertTrue(yazi.isDisplayed());

//      Selenium Webdriver Yazısının sitede oldugunu test et
        Assert.assertEquals("Selenium Webdriver", yazi.getText());
    }

    @Test
    public void test02() {
        // https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //"Display button after 10 seconds" butonuna basalım.
        WebElement display = driver.findElement(By.id("display-other-button"));
        display.click();

        WebElement enabled = driver.findElement(By.xpath("(//button)[6]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOf(enabled));

        // Enabled butonunun görünür olduğunu doğrulayalım.
        Assert.assertTrue(enabled.isDisplayed());

        // Enabled butona tıklayıp butonun gittigini dogrulayin.
        enabled.click();
        wait.until(ExpectedConditions.invisibilityOf(enabled));
        Assert.assertFalse(enabled.isDisplayed());

    }

    @Test
    public void test03() {
        // https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //"Enable button after 10 seconds" butonuna basalım.
        WebElement enable = driver.findElement(By.id("enable-button"));
        enable.click();
        WebElement button = driver.findElement(By.cssSelector("[id='disable']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        // Button butonunun erişilebilir olduğunu doğrulayalım.
        Assert.assertTrue(button.isEnabled());

    }

    @Test
    public void test04() {
        // https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver ");

        //checkbox checkbox'ının secili olmadığını dogrulayalım
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        Assert.assertFalse(checkbox.isSelected());

        //Check checkbox after 10 seconds" butonuna basalım
        WebElement check = driver.findElement(By.cssSelector("[id='checkbox']"));
        check.click();

        checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(20)).
                until(ExpectedConditions.elementToBeSelected(checkbox));

        //checkbox checkbox'ının secili oldugunu dogrulayalım
        Assert.assertTrue(checkbox.isSelected());

    }
}