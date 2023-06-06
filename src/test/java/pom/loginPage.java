package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

   protected WebDriver driver;
    //using constructor
    public loginPage (WebDriver driver){
        this.driver = driver;
    }

     private By newUser = By.linkText("New user? Signup");
     private By errormsg = By.xpath("//h2[@class='errorMessage']");
     private By userName = By.id("email1");
     private By password = By.xpath("//input[@placeholder='Enter Password']");
     private By signin = By.className("submit-btn");


     public  ReagisterPage register (){
         driver.findElement(newUser).click();
         ReagisterPage page = new ReagisterPage(driver);
         return page;
     }





    public void loginToApplication(String uname, String upass){

        driver.findElement(userName).sendKeys(uname);
        driver.findElement(password).sendKeys(upass);
        driver.findElement(signin).click();

    }


    public  String errormsgCapture(){
        String  err_msg = driver.findElement(errormsg).getText();
        return err_msg;
    }

}
