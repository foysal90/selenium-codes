package islahiArt;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class customeDataProvider {

   static  XSSFWorkbook wb;
    @DataProvider (name = "loginDataFromExcel")

    public static Object [][] getDataFromExcel() {


        try {
            wb = new XSSFWorkbook(new File(System.getProperty("user.dir")+"/dataTest/databook.xlsx"));
        } catch (IOException e) {
            System.out.println("Unable to load the file : " + e.getMessage());
        } catch (InvalidFormatException e) {
            System.out.println("Invalid format : " + e.getMessage());
        }

        int row = wb.getSheet("user").getPhysicalNumberOfRows();
        int column = wb.getSheet("user").getRow(0).getPhysicalNumberOfCells();

        Object [][] arr = new Object[row][column];

        for (int i =0;i<row;i ++){
            for (int j=0;j<column;j++){
                arr [i][j] = wb.getSheet("user").getRow(i).getCell(j).getStringCellValue();

            }
        }


        return arr;
    }
}
