package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class automationexercise01 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String url = driver.getCurrentUrl();
        String beklenenUrl = "https://automationexercise.com/";
        if (url.equals(beklenenUrl)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

//        4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//        5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        boolean newUserSignUpGorunurMu = driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
        System.out.println(newUserSignUpGorunurMu);

//        6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("yusufaltunok");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("yusuf1325@gmail.com");

//        7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

        //reklamı kapat
//        driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
//        driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();


//        8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        boolean hesapBilgGorunurMu = driver.findElement(By.xpath("(//h2)[1]")).isDisplayed();
        System.out.println("Hesap bilgilerini girin görünüyor mu ? " + hesapBilgGorunurMu);


        //Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        WebElement unvan = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        unvan.click();
        unvan.sendKeys(Keys.TAB, "Yusuf ALTUNOK", Keys.TAB, "yusuf6677", Keys.TAB, "9",
                Keys.TAB, "January", Keys.TAB, "2000");

        //'Bültenimize kaydolun!' onay kutusunu seçin.
        //'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        //Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement firstName = driver.findElement(By.xpath("//*[@id='first_name']"));
        firstName.sendKeys("yusuf ", Keys.TAB, " murat", Keys.TAB, "techpro", Keys.TAB, "Yenimahalle",
                Keys.TAB, "United States", Keys.TAB, "USA", Keys.TAB, "Florida", Keys.TAB, "Washington",
                Keys.TAB, "007", Keys.TAB, "911", Keys.TAB, Keys.ENTER);

       // driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

        //'HESAP OLUŞTURULDU!' görünür
        System.out.println("Hesap Oluşturuldu Görünüyor mu?" + driver.findElement(By.xpath("//h2[1]")).isDisplayed());

        //'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        System.out.println("Kullanıcı adı olarak oturum açıldı mı" + driver.findElement(By.xpath("//*[text()='Yusuf ALTUNOK']")).isDisplayed());

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //18. 'HESAP SİLİNDİ!' görünür
        System.out.println("Hesap Silindi mi? " + driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());

        //ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();


        driver.close();


    }
}
