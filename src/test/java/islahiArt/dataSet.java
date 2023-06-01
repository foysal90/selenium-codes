package islahiArt;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public  class dataSet {
    @Test
   public void setData() throws IOException, InvalidFormatException, InterruptedException {
        File src = new File("./dataTest/databook.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(src);

        String cityName =wb.getSheet("details").getRow(0).getCell(1).getStringCellValue();
        System.out.println(cityName);
        String cityName1 =wb.getSheet("details").getRow(1).getCell(1).getStringCellValue();
        System.out.println(cityName1);
        int cityName2 = (int) wb.getSheet("details").getRow(2).getCell(1).getNumericCellValue();
        System.out.println(cityName2);
        int cityName3 = (int) wb.getSheet("details").getRow(3).getCell(1).getNumericCellValue();
        System.out.println(cityName3);

//       int  sheets = wb.getNumberOfSheets();
//        System.out.println(sheets);

//        XSSFSheet s1 = wb.getSheet("details");
//        XSSFRow r1 = s1.getRow(1);
//        XSSFCell c1 = r1.getCell(1);
//
//        String v =c1.getStringCellValue();
//        System.out.println(v);
//        int rows = s1.getPhysicalNumberOfRows();
//
//        System.out.println(rows);

        wb.close();



    }
}
