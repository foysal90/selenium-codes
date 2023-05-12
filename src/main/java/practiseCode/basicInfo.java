package practiseCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class basicInfo {
    static WebDriver driver;
   public static WebElement INFO(WebDriver driver){

       driver.findElement(By.xpath("//input[@placeholder='Name' and contains(@id,'name')]")).sendKeys("Foysal");

       driver.findElement((By.name("email"))).sendKeys("ahmef70@gmail.com");
       driver.findElement(By.id("password")).sendKeys("123456");


       return null;
   }

   public static WebElement checkBox(WebDriver driver) throws InterruptedException {

       List<WebElement> allCheckboxes=driver.findElements(By.className("interest"));
       Thread.sleep(3000);
       System.out.println(allCheckboxes.size());

       // 7 times
       for(WebElement ele:allCheckboxes)
       {
           String e = ele.getText();
           System.out.println(e);
           ele.click();
//            if (e.equals("Automation Testing")){
//                ele.click();
//            }

       }
       return null;
   }

   public static WebElement dropDown(WebDriver driver) throws InterruptedException {
       driver.findElement(By.xpath("//input[contains(@value,'Male')]")).click();

       WebElement state = driver.findElement(By.id("state"));
       System.out.println(state.getText());
       Select st = new Select(state);
       st.selectByValue("Assam");

       Thread.sleep(1000);

       WebElement hobbies = driver.findElement(By.id("hobbies"));
       System.out.println(hobbies.getText());
       Select hob = new Select(hobbies);
       hob.selectByVisibleText("Playing");
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
       driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
       return null;
   }

   public static void closeBrowser(WebDriver driver){
       driver.quit();
   }

}
