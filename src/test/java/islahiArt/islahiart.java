package islahiArt;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public  class islahiart extends basicIslahi {




    @Parameters({"email","fname","lname","pwd","cpwd"})


    @Test
    public void signUp(@Optional("Foysal") String email, String fname, String lname, String pwd, String cpwd ) throws InterruptedException {
        //driver.findElement(By.xpath("//body/div[@id='page']/header[@id='masthead']/div[@id='ast-desktop-header']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a[1]/span[1]//*[name()='svg']//*[name()='path' and contains(@d,'M84.6,62c-')]")).click();

        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Sign Up']")).click();
        //driver.findElement(By.linkText("Sign")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys(email);
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='First Name'])[1]")).sendKeys(fname);
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='Last Name'])[1]")).sendKeys(lname);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys(pwd);
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='Confirm Password'])[1]")).sendKeys(cpwd);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@name='xoo_el_reg_terms'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[normalize-space()='Sign Up'])[1]")).click();
        Thread.sleep(3000);
        WebElement signUpErrorMsg =driver.findElement(By.xpath("//div[@class='xoo-el-notice-error registration-error-email-exists']"));
        String errorText = signUpErrorMsg.getText();
        System.out.println("Error Text is : " + errorText);

        if (errorText.equalsIgnoreCase("An account is already registered with your email address. Please log in.")){
            Assert.assertTrue(signUpErrorMsg.isDisplayed(),"Please Check The Error");
            System.out.println("Test Passed");
        }
        else {
            Assert.assertFalse(true,"Something went wrong");
        }
    }




    @Parameters ({"email","pwd"})
    @Test (dependsOnMethods = {"signUp"})

    public void login(String email, String pwd) throws InterruptedException {
        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='xoo-el-login-tgr xoo-el-active'][normalize-space()='Login'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("xoo-el-username")).sendKeys(email);
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(pwd);

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@name='xoo-el-rememberme'])[1]")).click();


        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Sign In'])[1]")).click();

        Thread.sleep(5000);
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);

        String expectedURL ="https://islahiart.com/my-account/?login=success";

        Assert.assertEquals(actualURL, expectedURL);
        if(actualURL.equalsIgnoreCase(expectedURL)) {
            System.out.println("user successfully logged in");
        }
        else {
            System.out.println("Error occured and  login failed");
        }


        Thread.sleep(5000);

        driver.findElement(By.xpath("(//a[contains(text(),'Log out')])[1]")).click();
        Thread.sleep(3000);
        String logout = driver.getCurrentUrl();
        System.out.println(logout);

        String logOutConf ="https://islahiart.com/my-account/";

        Assert.assertEquals(logout, logOutConf);
        if(actualURL.equalsIgnoreCase(expectedURL)) {
            Assert.assertTrue(true);
            System.out.println("user successfully logged out");
        }
        else {
            Assert.assertTrue(false);
            System.out.println("logged out failed");
        }

    }



}
