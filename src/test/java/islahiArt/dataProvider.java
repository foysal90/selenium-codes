package islahiArt;

import org.testng.annotations.DataProvider;

public class dataProvider {

    @DataProvider(name="loginData")

    public static Object [][] getData (){

        Object[][] data = new Object[3][2];
        data [0][0] = "abc123@admin.com";
        data [0][1] = "abc123";

        data [1][0] = "fail123@admin.com";
        data[1][1] = "failed123";

        data [2][0] = "something321@nothing.com";
        data [2][1] = "pass2365";
        return data;
    }
}
