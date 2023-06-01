package islahiArt;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class  basicIslahi {
    static WebDriver driver;
    @BeforeClass
    public void openBrowser() {

        driver = library.startBrowser("Chrome", "https://islahiart.com/");
        //utility.screenshot(driver);

    }

    @AfterClass
    public void closeBrowser() {

        driver.quit();

    }
}
