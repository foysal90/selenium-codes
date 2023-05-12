package practiseCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class windowHandles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window is : " + parentWindow);

        driver.findElement(By.id("newWindowBtn")).click();

        Set <String> handleWindow = driver.getWindowHandles();
        System.out.println("child window : " + handleWindow);

        for(String handle : handleWindow)
        {
            if (!parentWindow.equalsIgnoreCase(handle)){
                driver.switchTo().window(handle);
                driver.manage().window().maximize();

                driver.findElement(By.id("firstName")).sendKeys("foysal");
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("name")).sendKeys("ahmed");

//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//
//        driver.quit();

    }
}
