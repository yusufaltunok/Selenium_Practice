package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class yuzKezAddButton {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

/*
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");


        // Add Element butonuna 100 defa basınız

        for (int i = 0; i <100 ; i++) {
            WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
            addButton.click();
        }
        Thread.sleep(2000);

        // 100 defa basıldığını test ediniz
        int addedElementsCount = driver.findElements(By.xpath("//button[contains(text(), 'Delete')]")).size();
        if (addedElementsCount == 100) {
            System.out.println("Add Element butonuna 100 defa basıldı. Test PASSED");
        } else {
            System.out.println("Add Element butonuna 100 defa basılmadi. Test FAILED");
        }


        // 90 defa delete butonuna basınız
        for (int i = 0; i < 90 ; i++) {
            WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
            deleteButton.click();
        }
        Thread.sleep(2000);
        // 90 defa basıldığını doğrulayınız
        int deletedElementsCount = driver.findElements(By.xpath("//button[contains(text(), 'Delete')]")).size();
        if (deletedElementsCount == 10) {
            System.out.println("Delete butonuna 90 defa basildi. Test PASSED");
        } else {
            System.out.println("Delete butonuna 90 defa basilmadi. Test FAILED");
        }

       // Sayfayı kapatınız
       driver.close();

*/

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.navigate().to("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            WebElement addElement = driver.findElement(By.cssSelector("[onclick='addElement()']"));
            addElement.click();
            counter++;
        }

        Thread.sleep(2000);
// 100 defa basıldığını test ediniz
        if (counter == 100) {
            System.out.println("test 100 add PASSED " + counter);
        } else System.out.println("test 100 add FAİLED" + counter);


        // 90 defa delete butonuna basınız
        int counter1 = 0;
        for (int i = 0; i < 90; i++) {
            WebElement del = driver.findElement(By.xpath("(//*[@onclick='deleteElement()'])[1]"));
            del.click();
            counter1++;
        }
        Thread.sleep(2000);

// 90 defa basıldığını doğrulayınız
        if (counter1 == 90) {
            System.out.println("test 90 del PASSED" + counter1);
        } else System.out.println("test 90 del FAİLED " + counter1);


        // Sayfayı kapatınız
        driver.close();

        /*

         */
   /*


        /*ODEV!!!!!
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        // Add Element butonuna 100 defa basınız
        // 100 defa basıldığını test ediniz
        // 90 defa delete butonuna basınız
        // 90 defa basıldığını doğrulayınız
        // Sayfayı kapatınız




            // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
            driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

            // Add Element butonuna 100 defa basınız
            WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
            for (int i = 0; i < 100; i++) {
                addButton.click();
            }


//        driver.findElement  ==>  tek bir elementi hedeflemek için kullanılır.
//        driver.findElements ==>  verilen bir locator ifadesine uygun olarak, sayfa üzerindeki tüm eşleşen elementleri bulur
//                                 ve bu elementleri bir liste olarak döndürür.
//

            // Add Element butonuna 100 defa basıldığını test ediniz
            List<WebElement> deleteButton = driver.findElements(By.xpath("//*[text()='Delete']"));//yani text'i delete olanları bir liste attık
            int deleteButtonSayisi = deleteButton.size();
            System.out.println(deleteButtonSayisi);

            if (deleteButtonSayisi == 100) {
                System.out.println("Test PASSED");
            } else {
                System.out.println("Test FAILED " + deleteButtonSayisi);
            }
            Thread.sleep(2000);

            // 90 defa delete butonuna basınız
            for (int i = 0; i < 90; i++) {
                deleteButton.get(i).click();
            }
            Thread.sleep(2000);

            // 90 defa delete butonuna basıldığını doğrulayınız
            int kalanDeleteButtonSayisi = driver.findElements(By.xpath("//*[text()='Delete']")).size();
            if (kalanDeleteButtonSayisi == 10) {
                System.out.println("Test PASSED");
            } else {
                System.out.println("Test FAILED " + deleteButtonSayisi);
            }

            driver.close();

         */




    }
}