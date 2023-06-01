package assignments;

import helper.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assignment {
@Test
    public void  verifyTitle() throws InterruptedException  {
        WebDriver driver = utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");

        String actualTitle = driver.getTitle();
        Thread.sleep(1000);
        System.out.println("Actual title is :"+actualTitle);

        String exp ="Learn Automation Courses";


        Assert.assertEquals(actualTitle, exp, "Title does not match......!!!!");
        System.out.println("running test is verifyTitle");

        driver.quit();
    }

    @Test
    public void loginInvalid() throws Exception {
        WebDriver driver = utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");

        driver.findElement(By.name("email1")).sendKeys("foysal@xyz.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(2000);
        String err = driver.findElement(By.className("errorMessage")).getText();

        System.out.println("error :" +err);

        String actualErr = "USER Email Doesn't Exist";
        String expErr = "USER Email Doesn't Exist";
        Assert.assertEquals(actualErr, expErr);

        System.out.println("running test is loginInvalid");


        driver.quit();
    }
}
