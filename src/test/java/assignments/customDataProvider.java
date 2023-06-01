package assignments;

import org.testng.annotations.DataProvider;

public class customDataProvider {

    @DataProvider(name="loginDataForApplication")
    public static Object[][] getDataForApp()
    {
        System.out.println("Test data getting generated");

        Object[][]arr=new Object[3][2];
        arr[0][0]="mukesh@email.com";
        arr[0][1]="mukesh@123";

        arr[1][0]="umang@email.com";
        arr[1][1]="umang@123";

        arr[2][0]="shiva@email.com";
        arr[2][1]="shiva@123";

        System.out.println("Test data generated");

        return arr;
    }
}
