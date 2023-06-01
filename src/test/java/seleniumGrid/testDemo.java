package seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class testDemo {
    @Test
    void signIn() throws MalformedURLException, InterruptedException {
        String hubURL = "https://foysalahmed_IjXUY0:NdzRQbAG3qpVPbz4RyVp@hub.browserstack.com/wd/hub";

        HashMap<String,String> map = new HashMap<>();
        map.put("os","OS X");
        map.put("osVersion","Ventura");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName","Chrome");
        cap.setCapability("browserVersion","latest");
        cap.setCapability("bstack:options",map);
        WebDriver driver = new RemoteWebDriver(new URL(hubURL),cap);
        driver.get("https://islahiart.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='xoo-el-login-tgr xoo-el-active'][normalize-space()='Login'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("xoo-el-username")).sendKeys("ahmef2370@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("123456");

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@name='xoo-el-rememberme'])[1]")).click();


        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Sign In'])[1]")).click();

        Thread.sleep(5000);
        String actualURL = driver.getCurrentUrl();
        System.out.println("Actual URL After user sucessfully logged in : " + actualURL);

        String expectedURL = "https://islahiart.com/my-account/?login=success";

        Assert.assertEquals(actualURL, expectedURL);
        if (actualURL.equalsIgnoreCase(expectedURL)) {
            System.out.println("user successfully logged in");
        } else {
            System.out.println("Error occured and  login failed");
        }

        driver.quit();


    }
}
