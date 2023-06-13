package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    /*
    Test Base class'ından obje oluşturmanın önünr geçmek için bu class'ı abstract yapabiliriz.
    TestBase tb = new TestBase(); şeklinde obje oluşturmanın önüne geçmiş oluruz.
    Bu class'a extends yaptığımız test class'larından ulaşabiliriz..
     */
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        bekle(2);
        driver.quit();

    }
    //HARD WAIT (Bekleme Methodu)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //AcceptAlert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //DismissAlert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    //getTextAlert
    public String getTextAlert(){
       return driver.switchTo().alert().getText();
    }
    //sendKeysAlert
    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

}
