package practiseCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class newTest {





        WebDriver driver;
        @BeforeMethod
        public void beforeMethod() throws InterruptedException {

            driver=new ChromeDriver();
            Thread.sleep(1000);
            driver.get("https://the-internet.herokuapp.com/login");
        }
        @Test
        @Parameters({"username","password"})

        public void test(String user, String pass)
        {
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(pass);
        }

        @AfterMethod
        public void afterMethod() {
            driver.close();
        }

    }


