package pof;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pageObjectFactory {

    protected WebDriver driver;

    public  pageObjectFactory(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//h2[@class='errorMessage']") WebElement errormessage;
    @FindBy (id = "email1") WebElement username;
    @FindBy (xpath = "//input[@placeholder='Enter Password']") WebElement password;
    @FindBy (className = "submit-btn") WebElement login;



    public  void newLoginTest( String usernames, String userpass){

        username.sendKeys(usernames);
        password.sendKeys(userpass);
        login.click();

    }

    public  String getErrormsg(){
        String findErrormsg = errormessage.getText();
        return findErrormsg;
    }
}
