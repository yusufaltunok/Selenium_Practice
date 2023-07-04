package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HesapMakinasi extends TestBase {
    Random random;

    @Test
    public void test01() {
//     https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get(" https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

//    Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım

        //div[@id='calculator']//span[contains(text(),'0')]
        for (int i = 0; i < 2; i++) {
            random = new Random();
            int randomSayi = random.nextInt(10);
            driver.findElement(By.xpath("//div[@id='calculator']//span[contains(text(),'" + randomSayi + "')]")).click();
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////
        List<WebElement> isaretler = driver.findElements(By.xpath("//*[@id='calculator']//span[contains(@class,'operator btn btn-outline-success')]"));

        int index = random.nextInt(isaretler.size());
        WebElement islemler = isaretler.get(index);

        islemler.click();

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 2; i++) {
            random = new Random();
            int randomSayi = random.nextInt(10);
            driver.findElement(By.xpath("//div[@id='calculator']//span[contains(text(),'" + randomSayi + "')]")).click();

        }
        String kova2 = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        System.out.println("kova2 = " + kova2);
        String[] split = kova2.split("[-+x÷]");

        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));

        String rakam1 = split[0];
        double rakam11 = Double.parseDouble(rakam1);
        System.out.println("rakam11 = " + rakam11);


        String rakam2 = split[1];

        double rakam22 = Double.parseDouble(rakam2);
        System.out.println("rakam22 = " + rakam22);

        //Sonucu konsola yazdırıp
        driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']")).click();


        //Sonucun doğrulamasını yapalım
        double sonuc = 0;
        switch (islemler.getText()) {
            case "+":
                sonuc = rakam11 + rakam22;
                break;
            case "-":
                sonuc = rakam11 - rakam22;
                break;
            case "x":
                sonuc = rakam11 * rakam22;
                break;
            case "÷":
                sonuc = rakam11 / rakam22;
                break;
            default:
                System.out.println("Geçersiz işlem yönü");
                break;
        }
        System.out.println("sonuc = " + sonuc);

        WebElement sonEkran = driver.findElement(By.xpath("//*[@class='screen']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@class='screen']"), sonEkran.getText()));

        double screenActual = Double.parseDouble(sonEkran.getText());
        System.out.println("screenActual = " + screenActual);
        System.out.println("screen = " + screenActual);

        Assert.assertEquals(sonuc, screenActual, 0.001);



    }
}
