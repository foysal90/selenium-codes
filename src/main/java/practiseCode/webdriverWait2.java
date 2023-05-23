package practiseCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class webdriverWait2 {

    @Test
        void demo() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
           driver.findElement(By.xpath("//button[normalize-space()='Click me to start timer']")).click();

          // WebElement click = driver.findElement(By.xpath("//p[text()='WebDriver']"));
            WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement c = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='WebDriver']")));

           if (c.isDisplayed())
               System.out.println("Found.....!!!");

           else
               System.out.println("Unable to found....!!!");


        }
}
