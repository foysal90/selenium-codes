import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class foyTestDemo {
    @Test
    public  void testdemo(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fahmed.dev/");
        driver.findElement(By.xpath("//a[@class='nav-link'][normalize-space()='Skills']")).click();
    }
}
