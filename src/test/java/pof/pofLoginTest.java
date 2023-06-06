package pof;

import helper.utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pofLoginTest {
    @Test
    public  void test(){
        WebDriver driver = utility.startBrowser("Chrome",
                "https://freelance-learn-automation.vercel.app/login");
        pageObjectFactory pg = new pageObjectFactory(driver);
        pg.newLoginTest("abc@gmail.com", "1213654");
        Assert.assertTrue(pg.getErrormsg().contains("Email and Password Doesn't match"));

    }

}
