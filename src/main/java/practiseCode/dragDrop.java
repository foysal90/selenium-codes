package practiseCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class dragDrop {


    public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://jqueryui.com/");
            // it will click on droppable link
            driver.findElement(By.xpath("//a[normalize-space()='Droppable']")).click();
            WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
            driver.switchTo().frame(frame);

            Thread.sleep(2000);
            //drag
           WebElement src = driver.findElement(By.id("draggable"));

           //drop

          WebElement dest = driver.findElement(By.id("droppable"));

          Actions act = new Actions(driver);


        //using drag and drop method
//          act.dragAndDrop(src, dest).perform();
        act.dragAndDrop(src,dest);

        //using click and hold method
          act.clickAndHold(src).pause(Duration.ofSeconds(3)).moveToElement(dest).pause(Duration.ofSeconds(2)).release().build().perform();
          Thread.sleep(2000);
          driver.quit();



    }
}
