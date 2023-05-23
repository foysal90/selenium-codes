package practiseCode;

import helper.utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class islahiTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = utility.startBrowser("Chrome", "https://islahiart.com/");


        driver.findElement(By.xpath("//body/div[@id='page']/header[@id='masthead']/div[@id='ast-desktop-header']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a[1]/span[1]//*[name()='svg']//*[name()='path' and contains(@d,'M84.6,62c-')]")).click();

        //driver.findElement(By.xpath("//div[@class='dgwt-wcas-search-wrapp dgwt-wcas-has-submit fibosearch woocommerce dgwt-wcas-style-solaris js-dgwt-wcas-layout-icon dgwt-wcas-layout-icon js-dgwt-wcas-mobile-overlay-enabled dgwt-wcas-active']//div[@class='dgwt-wcas-search-icon js-dgwt-wcas-search-icon-handler']//*[name()='svg']")).click();

        WebElement women = driver.findElement(By.linkText("Women’s Clothing"));

        Actions act = new Actions(driver);

        act.moveToElement(women).perform();

//        WebElement ele = driver.findElement(By.xpath("//ul[@class='sub-menu']//li[@id='menu-item-2072']//a"));
//
//		String links = ele.getText();
//


        //System.out.println(links);

        driver.findElement(By.linkText("T-Shirts")).click();
        //Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='https://islahiart.com/shop/womens-comfortable-short-sleeve-tee/']//img[@class='show-on-hover']")).click();


        driver.findElement(By.xpath("//div[normalize-space()='Heather Navy']")).click();

        driver.findElement(By.xpath("//div[normalize-space()='L']")).click();
        driver.findElement(By.xpath("//a[@id='plus_qty']")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        driver.findElement(By.xpath("//div[@role='alert']//a[@class='button wc-forward wp-element-button'][normalize-space()='View cart']")).click();


        driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("foy21");

        //driver.findElement(By.xpath("//button[normalize-space()='Apply coupon']")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Checkout']")).click();

        driver.findElement(By.name("billing_first_name")).sendKeys("Foysal");
        driver.findElement(By.name("billing_last_name")).sendKeys("Ahmed");
        driver.findElement(By.xpath("//input[@placeholder='House number and street name']")).sendKeys("123 president street");
        driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("orlando");
        driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("32836");
        driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("4074170000");
        driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@id='ship-to-different-address-checkbox']")).click();
        Thread.sleep(2000);





//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        driver.findElement(By.xpath("//input[@id='terms']")).click();
//        driver.findElement(By.xpath("//button[@id='place_order']")).click();

        //driver.switchTo().alert().dismiss();


//        WebElement state = driver.findElement(By.id("billing_state"));
//        state.click();
//
//        System.out.println("List of States : "+state.getText());
//        Select s = new Select(state);
//        s.selectByVisibleText("Florida");
        driver.findElement(By.id("select2-billing_state-container")).click();


       driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input")).click();


        WebElement state = driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input"));
        System.out.println("List of States : "+state.getText());
        state.sendKeys("Florida");
        Thread.sleep(3000);
        state.sendKeys(Keys.ENTER);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']")));

        driver.findElement(By.xpath("//input[@placeholder='Card number']")).sendKeys("374245455400126");

        //driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys("10 26");
        //driver.switchTo().defaultContent();


        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(2000);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        //js.executeScript("arguments[0].scrollIntoView(true,element)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='place_order']")).click();












    }
}
