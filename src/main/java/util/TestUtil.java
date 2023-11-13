package util;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
    public static String[][] getDataFromExcel() throws IOException
    {
        FileInputStream file = new FileInputStream("src/main//resources/testData.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(file);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        XSSFRow row;
        XSSFCell cell;
        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(1).getLastCellNum();
        String[][] tabArray = new String[totalRows][totalCols];
        for(int r=1, i = 0;r<=totalRows;r++, i++)
        {
            row = (XSSFRow)sheet.getRow(r);
            for(int c=0, j=0;c<totalCols;c++, j++)
            {
                cell = row.getCell(c);
                tabArray[i][j] = cell.getStringCellValue();
            }
        }
        return tabArray;
    }
}
