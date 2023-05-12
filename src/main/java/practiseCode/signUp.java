package practiseCode;

import helper.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.List;


public class signUp {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = utility.startBrowser("Chrome","https://freelance-learn-automation.vercel.app/signup");


        Thread.sleep(3000);


        String expectedTitle = driver.findElement(By.xpath("//div[@class='main-container']")).getText();
        System.out.println("expectedTitle : "+expectedTitle);

        String actualTitle = driver.getTitle();
        System.out.println("Actual is : "+actualTitle);

       // Assert.assertEquals(actualTitle,expectedTitle);


        basicInfo.INFO(driver);

       basicInfo.checkBox(driver);
       basicInfo.dropDown(driver);
       basicInfo.closeBrowser(driver);







//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        driver.quit();


//
//        driver.findElement(By.partialLinkText("Signup")).click();
//
//        List <WebElement> ele = driver.findElements(By.xpath("//h4[normalize-space()='Interests']"));
//        int size = ele.size();
//
//        for(WebElement ele1:ele)
//        {
//            ele1.click();
//        }

    }
}

