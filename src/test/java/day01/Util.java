package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Util {

    public static WebDriver driver = new ChromeDriver();
    public static void setProperty() {
        System.setProperty("web driver.chrome.driver", "src/resources/driver/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
}
