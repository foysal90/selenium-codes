package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ReagisterPage {

    WebDriver driver;

    public ReagisterPage (WebDriver driver) {
        this.driver = driver;

    }
    private  By firstName = By.id("name");

    private  By lastName = By.name("email");

    private  By password = By.id("password");

    //private  By interest = By.xpath("(//label[normalize-space()='Automation Testing'])[1]");
    private  By interest = By.className("interest");
    private By sex = By.name("gender");
    private By state = By.id("state");
    private By hobby = By.id("hobbies");









    public void createUser () throws InterruptedException {
        driver.findElement(firstName).sendKeys("Foysal");
        driver.findElement(lastName).sendKeys("Ahmed");
        driver.findElement(password).sendKeys("abc123");
        //driver.findElement(interest).click();
        List<WebElement> allCheckboxes=driver.findElements(interest);


        // 7 times
        for(WebElement ele:allCheckboxes)
        {
            ele.click();
        }
        driver.findElement(sex).click();
        Thread.sleep(3000);
        Select st = new Select(driver.findElement(state));
        Thread.sleep(3000);
        st.selectByVisibleText("Karnataka");
        WebElement hobbies = driver.findElement(hobby);
        Select hobb = new Select(hobbies);
        hobb.selectByVisibleText("Playing");
        hobb.selectByVisibleText("Swimming");
    }
}
