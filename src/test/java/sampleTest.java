import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class sampleTest {

    @Test

    void n (){

        WebDriver driver = new ChromeDriver();
        driver.get("https://freelance-learn-automation.vercel.app/signup");
        List <WebElement> hobb = driver.findElements(By.xpath("//select[@id='hobbies']"));
        int c = hobb.size();
        System.out.println(c);
       List <WebElement> list = driver.findElements(By.xpath("//div[@class='interests-div']"));
        System.out.println(list.size());

        for (WebElement ele :list){
            String text = ele.getText();
            System.out.println(text);
        }

        driver.quit();
    }
}
