package testNG;

import helper.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class groupsDemo {

    WebDriver driver;


    @Test (groups={"sanity"})
    void demo1(){
        driver= utility.startBrowser("Chrome","https://islahiart.com/");
        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        driver.quit();

    }
    @Test (groups={"regression"})
    void demo2() throws InterruptedException {
        driver= utility.startBrowser("Chrome","https://islahiart.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='xoo-el-login-tgr xoo-el-active'][normalize-space()='Login'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("xoo-el-username")).sendKeys("fname");
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("pwd");
        driver.quit();

    }
    @Test (groups={"sanity","regression"})
    void demo3() throws InterruptedException {
        driver= utility.startBrowser("Chrome","https://islahiart.com/");
        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='xoo-el-login-tgr xoo-el-active'][normalize-space()='Login'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("xoo-el-username")).sendKeys("foysal");
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("pwd");

        Thread.sleep(1000);

        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Sign In'])[1]")).click();
        driver.quit();

    }
    @Test (groups={"regression"})
    void demo4() throws InterruptedException {

        driver= utility.startBrowser("Chrome","https://islahiart.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Sign Up']")).click();
        Thread.sleep(2000);
        driver.quit();




    }
    @Test (groups={"sanity"})
    void demo5() throws InterruptedException {

        driver= utility.startBrowser("Chrome","https://islahiart.com/");
        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        driver.findElement(By.xpath("//li[text()='Sign Up']")).click();


        Thread.sleep(2000);

        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("user");
        driver.quit();

    }


}
