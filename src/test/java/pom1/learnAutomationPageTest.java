package pom1;

import helper.utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.ReagisterPage;
import pom.loginPage;

public class learnAutomationPageTest {

    @Test

    public  void loginPageTestWithNonExitingUser() throws InterruptedException {
        WebDriver driver = utility.startBrowser
                ("Chrome", "https://freelance-learn-automation.vercel.app/login");
       // without page factory
        loginPage login = new loginPage(driver);
        login.loginToApplication("abc@admin.com","123654");
        Thread.sleep(3000);

        Assert.assertTrue(login.errormsgCapture().contains("USER Email Doesn't Exist"));

        System.out.println("Test Passed");

        driver.quit();


    }
  @Test
    public  void exitingUserInvalidCredientials() throws InterruptedException {
        WebDriver driver = utility.startBrowser
                ("Chrome", "https://freelance-learn-automation.vercel.app/login");

        loginPage login = new loginPage(driver);



       // driver.navigate().back();


        login.loginToApplication("admin@email.com","123654");
        Thread.sleep(3000);

        Assert.assertTrue(login.errormsgCapture().contains("Email and Password Doesn't match"));

        System.out.println("Test Passed");

       login.register().createUser();
       Thread.sleep(3000);

        driver.quit();


    }

}
