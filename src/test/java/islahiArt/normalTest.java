package islahiArt;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class normalTest extends basicIslahi {
    @Test
    void smokeTest() throws InterruptedException {

        driver.findElement(By.xpath("(//*[name()='path'])[7]")).click();
        library.screenshot(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='xoo-el-login-tgr xoo-el-active'][normalize-space()='Login'])[1]")).click();
        library.screenshot(driver);
        Thread.sleep(2000);
        driver.findElement(By.name("xoo-el-username")).sendKeys("ahmef2370@gmail.com");
        library.screenshot(driver);
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("123456");
        library.screenshot(driver);

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@name='xoo-el-rememberme'])[1]")).click();
        library.screenshot(driver);


        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Sign In'])[1]")).click();
        library.screenshot(driver);
        Thread.sleep(5000);
        String actualURL = driver.getCurrentUrl();

        System.out.println("Actual URL After user sucessfully logged in : " + actualURL);

        String expectedURL = "https://islahiart.com/my-account/?login=success";

        Assert.assertEquals(actualURL, expectedURL);
        if (actualURL.equalsIgnoreCase(expectedURL)) {
            System.out.println("user successfully logged in");
        } else {
            System.out.println("Error occured and  login failed");
        }


        WebElement men = driver.findElement(By.xpath("(//a[@class='menu-link'][contains(text(),'Men’s Clothing')])[1]"));
        library.screenshot(driver);

        Actions act = new Actions(driver);

        act.moveToElement(men).perform();



        driver.findElement(By.linkText("T-Shirts")).click();
        library.screenshot(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://islahiart.com/shop/summer-heavy-cotton-tee/']//img[@class='show-on-hover']")).click();
        library.screenshot(driver);
        List <WebElement> e = driver.findElements(By.xpath("(//table[@role='presentation'])[1]//div"));
        int count = e.size();
        System.out.println("Total size are :" + count);

        for (WebElement ele : e){
            String names = ele.getText();
            System.out.println("List of sizes : " +names);

            if (names.contains("M")) {
                ele.click();
                System.out.println("M was clicked");
                Thread.sleep(2000);

            }
        }

//
//        driver.findElement(By.xpath("//a[@id='plus_qty']")).click();
//        library.screenshot(driver);
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit'and normalize-space()='Add to cart']")).click();
        library.screenshot(driver);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@role='alert']//a[@class='button wc-forward wp-element-button'][normalize-space()='View cart']")).click();
        library.screenshot(driver);
        Thread.sleep(2000);

        //driver.findElement(By.xpath("//a[@id='plus_qty']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Checkout']")).click();
        library.screenshot(driver);
        Thread.sleep(5000);



    }

    @Test (dependsOnMethods = {"smokeTest"})
    void details () throws InterruptedException, IOException, InvalidFormatException {
        File src = new File("./dataTest/databook.xlsx");

        FileInputStream f1 = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(src);

        String streetName =wb.getSheet("details").getRow(0).getCell(1).getStringCellValue();
        System.out.println(streetName);
        String cityName =wb.getSheet("details").getRow(1).getCell(1).getStringCellValue();
        //int zipcode = (int) wb.getSheet("details").getRow(3).getCell(1).getNumericCellValue();

        WebElement address =driver.findElement(By.xpath("//input[@id='billing_address_1']"));
        library.screenshot(driver);
        address.clear();
        library.screenshot(driver);
        address.sendKeys(streetName);
        library.screenshot(driver);
        //address.sendKeys("123 president road");


        WebElement city = driver.findElement(By.id("billing_city"));
        library.screenshot(driver);
        city.clear();
        library.screenshot(driver);
        city.sendKeys(cityName);
        library.screenshot(driver);


        //city.sendKeys("orlando");
        List <WebElement> state =  driver.findElements(By.xpath("//select[@id='billing_state']"));
        int ss= state.size();

        for (WebElement state_ele : state){
            String states_name = state_ele.getText();
            System.out.println("States Name :" +states_name);
            Select s = new Select(state_ele);
            
            library.screenshot(driver);
            s.selectByVisibleText("Florida");
            library.screenshot(driver);

        }





        WebElement postcode =  driver.findElement(By.name("billing_postcode"));

        postcode.clear();
        library.screenshot(driver);

        postcode.sendKeys("32836");
        library.screenshot(driver);

        WebElement phoneNumber = driver.findElement(By.id("billing_phone"));
        library.screenshot(driver);
        phoneNumber.clear();
        library.screenshot(driver);
        phoneNumber.sendKeys("407-417-0000");
        library.screenshot(driver);
        Thread.sleep(2000);
        wb.close();




    }
    @Test (dependsOnMethods = {"details"})
    void payment_info() throws InterruptedException {
        driver.findElement(By.xpath("(//input[@id='shipping_method_0_printify_shipping_e'])[1]")).click();
        library.screenshot(driver);
        Thread.sleep(2000);
        WebElement frame = driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));
        library.screenshot(driver);
        driver.switchTo().frame(frame);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@name='cardnumber']")).sendKeys("374245455400126");
        library.screenshot(driver);
        Thread.sleep(2000);
        driver.findElement(By.name("exp-date")).sendKeys("05 27");
        library.screenshot(driver);
        Thread.sleep(2000);

        driver.findElement(By.name("cvc")).sendKeys("1021");
        library.screenshot(driver);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        library.screenshot(driver);
        Thread.sleep(5000);
    }
    @Test (dependsOnMethods = {"details","payment_info"})
    void place_order() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(2000);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        library.screenshot(driver);
        //js.executeScript("arguments[0].scrollIntoView(true,element)");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='terms']")).click();
        library.screenshot(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='place_order']")).click();
        library.screenshot(driver);
        Thread.sleep(5000);

        WebElement errorMeassge = driver.findElement(By.xpath("//div[@class='woocommerce-error cpsw-errors']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.invisibilityOf(errorMeassge));
        String errorText = errorMeassge.getText();
        library.screenshot(driver);
        System.out.println("Error message is : " +errorText);

        String errMsg ="The provided payment method failed authentication. Provide a new payment method to attempt this payment again.";
        boolean msgDisplay = errorMeassge.isDisplayed();
        library.screenshot(driver);
        System.out.println(msgDisplay);


    }


    @Test (dependsOnMethods = {"smokeTest","details","payment_info","place_order"}, alwaysRun = true)
    void logout() throws InterruptedException {
        driver.navigate().to("https://islahiart.com/my-account/");


        driver.findElement(By.xpath("(//a[contains(text(),'Log out')])[1]")).click();
        Thread.sleep(3000);
        String logout = driver.getCurrentUrl();
        System.out.println("currentURL after user logged out : " + logout);

        String logOutConf = "https://islahiart.com/my-account/";

        Assert.assertEquals(logout, logOutConf);
        if (logout.equalsIgnoreCase(logOutConf)) {
            Assert.assertTrue(true);
            System.out.println("user successfully logged out");
        } else {
            Assert.assertTrue(false);
            System.out.println("logged out failed");
        }

    }



}
