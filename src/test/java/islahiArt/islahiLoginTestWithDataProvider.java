package islahiArt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class islahiLoginTestWithDataProvider {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
        System.out.println("LOG:INFO - Running Before Method");
        System.out.println("LOG:INFO - Browser Getting Started");
        driver= library.startBrowser("Chrome", "https://islahiart.com/");
        library.screenshot(driver);
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
    @Test (dataProvider = "loginDataFromExcel", dataProviderClass = customeDataProvider.class)
    public void loginTest(String uname, String upass){


        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();



        driver.findElement(By.xpath("(//li[@class='xoo-el-login-tgr xoo-el-active'][normalize-space()='Login'])[1]")).click();

        driver.findElement(By.name("xoo-el-username")).sendKeys(uname);

        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(upass);


        driver.findElement(By.xpath("(//input[@name='xoo-el-rememberme'])[1]")).click();


        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Sign In'])[1]")).click();

        WebElement error = driver.findElement(By.xpath("//div[@class='xoo-el-notice-error ']"));


        String errText = error.getText();
        System.out.println("Error mesaage is :" + errText);
        if (errText.contains("Incorrect Email or Username. ")){
            Assert.assertTrue(error.isDisplayed());
            System.out.println("isErrorMessage Displayed ?..." + error.isDisplayed());
            System.out.println("Test Successfully Completed");
        }
        else {
            Assert.assertFalse(true);
            System.out.println("Test Failed");
        }


    }




}
