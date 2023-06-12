package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HerokuappOptions {
    /*
        ●https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void tesst01() {
//  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement option = driver.findElement(By.xpath("(//select)[1]"));
        Select select = new Select(option);

        select.selectByIndex(1);
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));

        System.out.println("***************************************");

//  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));

        System.out.println("***************************************");

//  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));

        System.out.println("***************************************");

//  4.Tüm dropdown değerleri(value) yazdırın
        select.getOptions().forEach(w-> System.out.println(w.getText()));

        System.out.println("***************************************");

//  5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        Assert.assertNotEquals(4,select.getOptions().size());
        int size = select.getOptions().size();
        System.out.println("Dropdown’un boyutu : "+size);
        System.out.println("False");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
