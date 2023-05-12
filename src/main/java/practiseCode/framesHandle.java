package practiseCode;

import helper.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class framesHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = utility.startBrowser("Chrome", "https://www.hyrtutorials.com/p/frames-practice.html");

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("hello");
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        driver.switchTo().frame(frame1);

        WebElement dd = driver.findElement(By.id("course"));

        Select sel = new Select(dd);
        sel.selectByVisibleText("Java");



        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("world");



    }
}
