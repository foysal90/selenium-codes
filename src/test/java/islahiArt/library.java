package islahiArt;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class library {

    public static WebDriver startBrowser(String browserName, String applicationURL) {

        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome")) {
            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("Safari") || browserName.equalsIgnoreCase("Safari Browser")) {
            driver = new SafariDriver();
        }
        if (browserName.equalsIgnoreCase("edge") || browserName.equalsIgnoreCase("edge driver")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Sorry we do not support the browser");
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(applicationURL);
        return driver;
    }

    public static void grid(){
        String hubURL = "https://foysalahmed_IjXUY0:NdzRQbAG3qpVPbz4RyVp@hub.browserstack.com/wd/hub";

        HashMap<String,String> map = new HashMap<>();
        map.put("os","OS X");
        map.put("osVersion","Ventura");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName","Chrome");
        cap.setCapability("browserVersion","latest");
        cap.setCapability("bstack:options",map);
    }

    public static void screenshot(WebDriver driver) {


        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        File des = new File("./screenshots/" + System.currentTimeMillis() + ".png");

        try {
            FileHandler.copy(src, des);
        } catch (IOException e) {

            System.out.println("message is : " + e.getMessage());
        }

    }
}