package practiseCode;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class fileDownload {

    public static void main(String[] args) {
        String downloadDirectory = System.getProperty("user.dir") + "/downloadFiles/";

        ChromeOptions opt = new ChromeOptions();

        Map <String,Object> download = new HashMap<>();
        download.put("download.default_directory",downloadDirectory);

        opt.setExperimentalOption("prefs",download);
        WebDriver driver = new ChromeDriver(opt);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[normalize-space()='File Download']")).click();

        driver.findElement(By.xpath("//a[normalize-space()='sample.png']")).click();

        File dest = new File(downloadDirectory);

        //if condition is just check if the file downloaded or not
        if (dest.length()>0)
        {
            System.out.println("File downloaded successfully");
        }
        else {
            System.out.println("File download failed");
        }

        driver.quit();
    }
}
