package practiseCode;

import helper.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class nestedFrames {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        driver.findElement(By.id("name")).sendKeys("Name");
        WebElement f3 = driver.findElement(By.xpath("//iframe[@id='frm3']"));
        driver.switchTo().frame(f3);

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("frame3");
        WebElement f2 = driver.findElement(By.xpath("//iframe[@id='frm2']"));
        driver.switchTo().frame(f2);

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("foysal");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("ahmed");
        driver.findElement(By.xpath("//input[@id='malerb']")).click();

        driver.findElement(By.xpath("//input[@id='englishchbx']")).click();

        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("frame");

        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("main webpage");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.quit();




//        WebElement dd = driver.findElement(By.id("course"));
//        Select dropDown = new Select(dd);
//        dropDown.selectByVisibleText("Python");
   }

}

