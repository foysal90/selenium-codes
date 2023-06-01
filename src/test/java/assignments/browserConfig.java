package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class browserConfig {
   static WebDriver driver;
@Test
    public  WebDriver bs() throws IOException {

        FileInputStream fis = new FileInputStream("./config.properties");

        Properties p = new Properties();
        p.load(fis);
        String s = p.getProperty("Chrome");
        if (s.equalsIgnoreCase("Chrome")){ 
            driver = new ChromeDriver();
            driver.get("url");
        }


    return driver;
}

}
