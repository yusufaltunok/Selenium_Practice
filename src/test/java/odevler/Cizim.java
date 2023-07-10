package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Cizim extends TestBase {
    @Test
    public void test01() {

//        - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        WebElement ekran = driver.findElement(By.className("signature-pad--body"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(ekran).
//                clickAndHold()
//                .moveByOffset(25, 100)
//                .moveByOffset(100,-75 )
//                .moveByOffset(-75, 200)
//                .moveByOffset(200, 0)
//                .moveByOffset(0, -500)
//                .moveByOffset(-500, 300)
//                .moveByOffset(300, 500)
//                .release().perform();


        actions.clickAndHold(ekran)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .release()
                .perform();




//        - Çizimden sonra clear butonuna basınız
        //driver.findElement(By.xpath("//button[@class='button clear']")).click();
    }

    @Test
    public void name() throws InterruptedException {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(yaziTahtasi);

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        actions.release().build().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();

    }

    @Test
    public void test03() {
        driver.get("http://szimek.github.io/signature_pad/");

        WebElement canvas = driver.findElement(By.xpath("(//*[@class='signature-pad--body'])/canvas"));
        int canvasWidth = canvas.getSize().getWidth();
        int canvasHeight = canvas.getSize().getHeight();
        int centerX = canvasWidth / 2;
        int centerY = canvasHeight / 2;// tahtanın ortasını bulduk
        int radius = Math.min(canvasWidth, canvasHeight) / 4; // Yarı çapı canvas boyutlarına gore ayarlama
        int numPoints = 5;
        double angle = 2 * Math.PI / numPoints;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Yıldız çizimini JavaScript kodu ile gerçekleştir
        StringBuilder jsCode = new StringBuilder();
        jsCode.append("var canvas = arguments[0];");
        jsCode.append("var context = canvas.getContext('2d');");
        jsCode.append("context.beginPath();");
        jsCode.append("context.moveTo(arguments[1], arguments[2]);");

        for (int i = 1; i <= numPoints * 2; i++) {
            int x, y;
            if (i % 2 == 0) {
                x = (int) (centerX + radius * Math.cos(i * angle));
                y = (int) (centerY + radius * Math.sin(i * angle));
            } else {
                x = centerX;
                y = centerY;
            }
            jsCode.append("context.lineTo(").append(x).append(",").append(y).append(");");
        }

        jsCode.append("context.closePath();");
        jsCode.append("context.stroke();");

        js.executeScript(jsCode.toString(), canvas, centerX, centerY);
    }

}
