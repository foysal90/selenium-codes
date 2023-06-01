package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class dataProviderDemo {

@Test (dataProvider = "LoginDataProvider", dataProviderClass = dataStoredLibrary.class)
    public void login(String user, String pwd){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
       // WebElement name =driver.findElement(By.xpath("//input[@id='email']"));

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
   WebElement w = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
   w.sendKeys(user);

    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);

    driver.findElement(By.xpath("//button[@name='login']")).click();


    }


}
