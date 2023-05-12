package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;

public class utility {

    public static WebDriver startBrowser(String browserName, String applicationURL){

         WebDriver driver = null;

        if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome"))
        {
            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("Safari") || browserName.equalsIgnoreCase("Safari Browser"))
        {
            driver = new SafariDriver();
        }
        if (browserName.equalsIgnoreCase("edge") || browserName.equalsIgnoreCase("edge driver"))
        {
            driver = new EdgeDriver();
        }
        else {
            System.out.println("Sorry we do not support the browser");
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(applicationURL);
        return driver;
    }

}
