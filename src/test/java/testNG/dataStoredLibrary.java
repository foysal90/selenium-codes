package testNG;

import org.testng.annotations.DataProvider;

public class dataStoredLibrary {


    @DataProvider(name = "LoginDataProvider")
    public Object [][] getData(){
        Object[][] data = {{"Admin@admin.com","admin123"}, {"ahmed@admin.com","abc"}};
        return data;
    }

}
