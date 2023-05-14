package practiseCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class webTable {

    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\91978\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        //launches the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
        ////*[@id="customers"]/tbody/tr[4]/td[1]
        int row=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr")).size();

        int col=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[4]/td/span")).size();
        System.out.println(row);
        System.out.println(col);

        for(int i=2;i<=row;i++)
        {
            for(int j=1;j<=col;j++)
            {
                String data=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td["+j+"]/span")).getText();
                System.out.println(data);
            }
            System.out.println();
        }
}}
