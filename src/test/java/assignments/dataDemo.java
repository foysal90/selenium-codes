package assignments;

import islahiArt.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dataDemo {

    WebDriver driver;
    @BeforeMethod
    public void setupBrowser()
    {
        System.out.println("LOG:INFO - Running Before Method");
        System.out.println("LOG:INFO - Browser Getting Started");
        driver= library.startBrowser("Chrome", "https://islahiart.com/");
        System.out.println("LOG:INFO - Browser Started");


    }


    @AfterMethod
    public void closeBrowser()
    {
        System.out.println("LOG:INFO - Running After Method");
        System.out.println("LOG:INFO - Browser Getting Closed");
        driver.quit();
        System.out.println("LOG:INFO - Browser Closed");
    }


    @Test(dataProvider = "loginDataForApplication",dataProviderClass = customDataProvider.class)
    public void test1(String email,String password)
    {

        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();

        driver.findElement(By.xpath("(//li[@class='xoo-el-login-tgr xoo-el-active'][normalize-space()='Login'])[1]")).click();

        driver.findElement(By.name("xoo-el-username")).sendKeys(email);


        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);

//        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='errorMessage']"))
//                .getText()
//                .contains("USER Email Doesn't Exist"),"Error message could not verify");

    }

}
