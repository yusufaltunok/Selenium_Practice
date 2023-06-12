package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ZeroWebAppSecurity {


    /*
  1.http://zero.webappsecurity.com/ Adresine gidin
2.Sign in butonuna basin
3.Login kutusuna “username” yazin
4.Password kutusuna “password.” yazin
5.Sign in tusuna basin(not: navigate.Back yapınız)
6.Pay Bills sayfasina gidin
7.“Purchase Foreign Currency” tusuna basin
8.“Currency” drop down menusunden Eurozone’u secin
9.“amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
   */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test01() throws InterruptedException {
        //2.Sign in butonuna basin
        driver.findElement(By.xpath("//button")).click();

        //3.Login kutusuna "username" yazin
        // 4.Password kutusuna "password." yazin
        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username", Keys.TAB, "password", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        //6.Online Bankingé tiklayip Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//strong)[2]")).click();//online banking locati
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();//paybills in locate

        // 7."Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("(//a)[17]")).click();

        //8."Currency" drop down menusunden Eurozone'u secin
        //9."amount" kutusuna bir sayi girin
        WebElement ddm = driver.findElement(By.xpath("(//select)[3]"));
        //Select select = new Select(ddm);
        ddm.sendKeys("Eurozone (euro)", Keys.TAB, "208");


        //10."US Dollars" in secilmedigini test edin
        WebElement usDolarButon = driver.findElement(By.cssSelector("input[id='pc_inDollars_true']"));
        Assert.assertTrue(!usDolarButon.isSelected());
        //Assert.assertFalse(usDolarButon.isSelected());


        //11."Selected currency" butonunu secin
        // 12."Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        //"Foreign currency cash was successfully purchased." yazisinin ciktigini kontrol edin
        usDolarButon.sendKeys(Keys.ARROW_RIGHT, Keys.TAB, Keys.ENTER, Keys.TAB, Keys.ENTER);//!!!!!!!

        WebElement dogrulama = driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertEquals("Foreign currency cash was successfully purchased.", dogrulama.getText());


    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}